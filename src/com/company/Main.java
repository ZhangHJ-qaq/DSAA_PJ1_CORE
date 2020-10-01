package com.company;

import com.sun.xml.internal.txw2.output.DataWriter;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//       Compress.compressSingleFile("D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase03XLargeSingleFile\\2.csv",
//              "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase03XLargeSingleFile\\2_compressed.csv");
//        Compress.decompressSingleFile(
//                "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase03XLargeSingleFile\\2_compressed.csv",
//             "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase03XLargeSingleFile\\2_recovered.csv");


        Compress.compressSingleFile(
                "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase02NormalSingleFile\\1.txt",
                "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase02NormalSingleFile\\1_compressed.txt"
        );
        Compress.decompressSingleFile(
                "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase02NormalSingleFile\\1_compressed.txt",
                "D:\\OneDrive\\DSAA\\pj1\\testcases\\testcase02NormalSingleFile\\1_recovered.txt");

//       Compress.compressSingleFile("D:\\test.txt","D:\\text_com.txt");
//       Compress.decompressSingleFile("D:\\text_com.txt","D:\\text_re.txt");


    }


}
