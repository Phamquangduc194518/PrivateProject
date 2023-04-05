//package com.t3h.exceptionandfile;
//
//import java.io.File;
//
//public class DemoMethodFile {
//    public void testSomeMethod(String path){
//        File f = new File(path);
////        f.delete()
//
//
//    }
//
//    public void printAllChildren(String path){
//
//        File f = new File(path);
//        if (!f.exists()){
//            return;
//        }
//        System.out.println("path: "+ f.getPath());
//        if (f.isDirectory()){
//            for (String childPath : f.list()) {
//                printAllChildren(path+File.separator+childPath);
//            }
//        }
//    }
//}
