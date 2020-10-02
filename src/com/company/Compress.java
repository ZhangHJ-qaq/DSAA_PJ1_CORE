package com.company;

import com.company.utilities.CastArrayUtil;
import com.company.utilities.Utility;

import java.io.*;
import java.util.*;

public class Compress {

    public static void compressSingleFile(String src, String des) throws IOException {

        long startTime = System.currentTimeMillis();

        //构造输入和输出文件
        File srcFile = new File(src);
        File desFile = new File(des);

        //构造输入流
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(srcFile)));

        //构造输出流
        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(desFile)));

        byte[] srcFileBytes = new byte[(int) srcFile.length()];

        //读入源文件的字节流
        in.read(srcFileBytes);

        in.close();

        //构造用于封装压缩后文件信息的对象
        HuffmanSingleFileData huffmanSingleFileData = new HuffmanSingleFileData();

        //由源文件的字节数组构造哈夫曼树
        HuffmanTree myTree = HuffmanTree.generateHuffmanTree(srcFileBytes);

        huffmanSingleFileData.huffmanTree = myTree;
        huffmanSingleFileData.originalFilename = srcFile.getName();
        huffmanSingleFileData.originalFileSize = srcFile.length();

        //获取压缩后的字节数组
        byte[] compressedBytes = myTree.encode(srcFileBytes);

        huffmanSingleFileData.compressedBytes = compressedBytes;
        huffmanSingleFileData.numOfZerosAdded = myTree.getNumberOfZerosAdded();

        out.writeObject(huffmanSingleFileData);
        out.close();

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000.0);
    }

    public static void decompressSingleFile(String src, String des) throws IOException, ClassNotFoundException {

        long startTime = System.currentTimeMillis();

        //初始化源文件和目标文件对象
        File srcFile = new File(src);
        File desFile = new File(des);

        //获取输入输出流
        ObjectInputStream in = new ObjectInputStream(
                new DataInputStream(new BufferedInputStream(new FileInputStream(srcFile))));
        DataOutputStream out =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream(desFile)));

        //一次性获得文件的全部数据
        HuffmanSingleFileData huffmanSingleFileData = (HuffmanSingleFileData) in.readObject();

        //得到字符和二进制字符串对应的哈希表
        HuffmanTree huffmanTree = huffmanSingleFileData.huffmanTree;

        //在哈夫曼树中对其进行解码
        byte[] recoveredBytes = huffmanTree.decode(huffmanSingleFileData.compressedBytes,
                huffmanSingleFileData.originalFileSize);

        out.write(recoveredBytes);
        out.close();

        long endTime=System.currentTimeMillis();

        System.out.println((endTime-startTime)/1000.0);
    }


}
