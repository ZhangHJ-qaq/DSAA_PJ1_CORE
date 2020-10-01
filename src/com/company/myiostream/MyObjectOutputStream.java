package com.company.myiostream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

    public StringBuilder bufferArea = new StringBuilder();//输出的缓冲区，当缓冲区超过8个二进制位时，就会自动转换成一个byte输出
    public int numOfZerosAdded;

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);

    }

    public void add(String code) throws IOException {

        //在缓冲区添加准备输出的内容
        bufferArea.append(code);

        //如果添加后，缓冲区有大于等于8个的二进制位，则自动输出
        while (bufferArea.length() >= 8) {
            byte byteToBeWritten = (byte) Integer.parseInt(bufferArea.substring(0, 8), 2);
            this.writeByte(byteToBeWritten);
            this.bufferArea.delete(0, 8);
        }

    }

    /**
     * 将缓冲区内的内容作为一个byte输出。如果位数不够，则用0凑
     */
    public void writeLast() throws IOException {
        while (this.bufferArea.length() < 8) {
            this.bufferArea.append(0);
            numOfZerosAdded++;
        }
        byte byteToBeWritten = (byte) Integer.parseInt(bufferArea.substring(0, 8));
        this.writeByte(byteToBeWritten);
    }


}
