//package com.t3h.exceptionandfile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//
//public class DemoRandomAssetfile {
//    public void readFile(String path){
//        try {
//            RandomAccessFile rd = new RandomAccessFile(path, "r");
//            String line = rd.readLine();
//            while (line != null ){
//                String utf8 = new String(line.getBytes("ISO-8859-1"),
//                        "UTF-8");
//                System.out.println(utf8);
//                line = rd.readLine();
//
//
//
//
//            }
//            rd.close();
//        } catch (IOException e) {
//
//        }
//    }
//}
