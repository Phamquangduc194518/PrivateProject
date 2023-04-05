package com.t3h.exceptionandfile;

public class Main {
    public static void main(String[] args) {
//        String numberStr = "12";
//        int number = Integer.parseInt(numberStr);
//
//        int a = 0;
////        int c = 10/a;
//        System.out.println("result.....");
//
//        Person p = null;
//
//        Person.testStaticPrintInfo(p);
//
//        String numberStr1 = "0";
//        String numberStr2 = "1a";
//        try {
//            int numberOne = Integer.parseInt(numberStr1);
//            int resultNumber = 10/numberOne;
//
//        }catch (NumberFormatException e){
//            System.out.println("error number format exception");
//        }catch (ArithmeticException e){
//            System.out.println("by zero");
//        }catch (Exception e){
//            System.out.println("Something went wrong");
//        }
//
//        DemoMethodFile demoMethodFile = new DemoMethodFile();
//
//        demoMethodFile.printAllChildren("C:\\Users\\PC\\Desktop");


//        DemoRandomAssetfile rd = new DemoRandomAssetfile();
//        rd.readFile("student.txt");
        MrgItemRss mrgItemRss = new MrgItemRss();
//        mrgItemRss.readLocal();
        mrgItemRss.readDataRss24H("https://cdn.24h.com.vn/upload/rss/tintuctrongngay.rss");
        mrgItemRss.printAll();

//        new DownloadFile().downloadFile("https://c1-ex-swe.nixcdn.com/NhacCuaTui981/DaDenLuc-SoobinHoangSonSlimV-5943193.mp3");
    }
}