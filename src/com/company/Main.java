package com.company;

import com.sun.xml.internal.txw2.output.DataWriter;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CompressResult compressResult = Compress.compress(
                "D:\\testcases\\testcase07XlargeSubFolders",
                "D:\\testttt.haojie"
        );
        System.out.printf("File size is %f MB. Time consumed is %f s. Compression speed is %f MB/s\n"
                , compressResult.fileSize, compressResult.timeConsumed, compressResult.speed);

        CompressResult compressResult1 = Compress.decompress(
                "D:\\testttt.haojie",
                "D:\\testdecompress"
        );

        System.out.printf("File size is %f MB. Time consumed is %f s. Decompression speed is %f MB/s\n"
                , compressResult1.fileSize, compressResult1.timeConsumed, compressResult1.speed);
    }


}
