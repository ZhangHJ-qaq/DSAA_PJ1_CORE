package com.company;

import com.company.myiostream.MyObjectOutputStream;
import com.company.utilities.CastArrayUtil;
import com.company.utilities.Utility;

import java.io.*;
import java.util.*;

public class Compress {

    public static void compressSingleFile(String src, String des) throws IOException {

        long startTime = System.currentTimeMillis();

        //构造输入和输出文件
        File scrFile = new File(src);
        File desFile = new File(des);

        //构造输入流
        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(scrFile)));

        //构造输出流
        MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(desFile)));

        byte[] srcFileBytes = new byte[(int) scrFile.length()];

        dataInputStream.read(srcFileBytes);

        dataInputStream.close();

        //由源文件的字节数组构造哈夫曼树
        HuffmanTree myTree = HuffmanTree.generateHuffmanTree(srcFileBytes);

        //得到字节和二进制串对应的编码表
        HashMap<Byte, String> hashMap = myTree.getEncodingTable();

        myObjectOutputStream.writeObject(hashMap);

        //遍历源文件的字节数组，输出到目标文件
        for (int i = 0; i <= srcFileBytes.length - 1; i++) {
            myObjectOutputStream.add(hashMap.get(srcFileBytes[i]));
        }

        //输出最后没有输出的几位，不够的用0凑
        myObjectOutputStream.writeLast();

        srcFileBytes = null;

        //输出二进制位结束的信号，输出在末尾加入的0的个数
        myObjectOutputStream.writeObject("End Of Binary Value");
        myObjectOutputStream.writeInt(myObjectOutputStream.numOfZerosAdded);

        String fileName = scrFile.getName();
        myObjectOutputStream.writeObject(fileName);

        myObjectOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.printf("%f\n", (endTime - startTime) / 1000.0);

    }

    public static void decompressSingleFile(String src, String des) throws IOException, ClassNotFoundException {

        long startTime = System.currentTimeMillis();

        //初始化源文件和目标文件对象
        File srcFile = new File(src);
        File desFile = new File(des);

        //获取输入输出流
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new DataInputStream(new BufferedInputStream(new FileInputStream(srcFile))));
        DataOutputStream dataOutputStream =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream(desFile)));


        //从压缩过的文件中读取存储了编码信息的hashmap
        HashMap<Byte, String> hashMap = (HashMap<Byte, String>) objectInputStream.readObject();

        //反转编码用的哈希表
        HashMap<String, Byte> reversedHashmap = new HashMap<>();
        Set<Map.Entry<Byte, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<Byte, String> entry : entrySet
        ) {
            reversedHashmap.put(entry.getValue(), entry.getKey());
        }


        //输入的缓冲区
        StringBuilder bufferArea = new StringBuilder();


        LinkedList<Byte> resultLinkedList = new LinkedList<>();

        while (true) {

            boolean flag = false;
            int numOfZeroAdded = 0;

            //每次从输入流里读取至多32个字节
            for (int i = 0; i < 32; i++) {
                try {
                    bufferArea.append(Utility.to8DigitBinaryString(objectInputStream.readByte()));

                    //如果二进制位的内容还没有结束，此处会抛出异常，继续readByte。如果二级制位的内容结束了，此处会得到
                    //"End Of Binary Value"，不抛出异常
                    objectInputStream.readObject();

                    //如果能运行到这里，说明二进制位的读取结束了
                    flag = true;
                    numOfZeroAdded = objectInputStream.readInt();
                    break;
                } catch (Exception ignored) {
                }
            }

            //如果最后一次读取，则去除之前压缩时在最后加的0
            if (flag) {
                for (int i = 0; i < numOfZeroAdded; i++) {
                    bufferArea.deleteCharAt(bufferArea.length() - 1);
                }
            }

            //两根指针变量，用来解析读取到的二进制字符串
            int firstPtr = 0;
            int lastPtr = 0;

            while (lastPtr <= bufferArea.length()) {

                while (lastPtr <= bufferArea.length()) {
                    //如果夹在两根指针之间的字符串在反转后的哈希表中被找到，则找出对应的字节
                    Byte btyeeee=reversedHashmap.get(bufferArea.substring(firstPtr,lastPtr));
                    if (btyeeee!=null) {
                        resultLinkedList.add(btyeeee);
                        firstPtr = lastPtr;
                        break;
                    }
                    lastPtr++;
                }

            }

            bufferArea.delete(0, firstPtr);

            if (flag) break;


        }

        objectInputStream.close();

        byte[] bytes = new byte[resultLinkedList.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = resultLinkedList.removeFirst();
        }

        dataOutputStream.write(bytes);

        dataOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.printf("%f", (endTime - startTime) / 1000.0);

    }


}
