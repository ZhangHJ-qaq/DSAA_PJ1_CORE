package com.company;

import java.io.Serializable;
import java.util.Map;

/**
 * 将数据写入二进制文件的一个集合
 */
public class HuffmanSingleFileData implements Serializable {
    HuffmanTree huffmanTree;//压缩时用的哈夫曼树
    byte[] compressedBytes;//压缩后的比特
    String originalFilename;//压缩前的文件名
    int numOfZerosAdded;//压缩时在二进制串末尾加入的0的个数
    long originalFileSize;

}
