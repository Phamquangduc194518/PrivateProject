package com.t3h.exceptionandfile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MrgItemRss {
    private List<ItemRss> rsses;

    public MrgItemRss() {
        this.rsses = new ArrayList<>();
    }

//    public void readLocal() {
//        String fileName = "rss.txt";
//        try {
//            RandomAccessFile rd = new RandomAccessFile(fileName, "r");
//
//            while (true) {
//                String line = rd.readLine();
//                if (line == null) {
//                    break;
//                }
//                line = rd.readLine();
//                String title = null;
//                if (line.equals("<title>")) {
//                    title = rd.readLine();
//                    rd.readLine();
//                } else {
//                    title = line.replace("<title>", "");
//                    title = title.replace("</title>", "");
//                }
//                rd.readLine();//<description>
//                rd.readLine();
//                line = rd.readLine();
//                int index = line.indexOf("<br");
//                String description = line.substring(0, index);
//                rd.readLine();
//                rd.readLine();//</description>
//                rd.readLine();//<link>
//                String htmlLink = rd.readLine();
//                rd.readLine(); //</link>
//                String datePublic = rd.readLine();
//                datePublic = datePublic.replace("<pubDate>", "");
//                datePublic = datePublic.replace("</pubDate>", "");
//                rd.readLine();
//                String imageLink = rd.readLine();
//                rd.readLine();
//                rd.readLine();
//
//
//                title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
//                description = new String(description.getBytes("ISO-8859-1"), "UTF-8");
//
//
//                rsses.add(new ItemRss(title, description, imageLink, htmlLink, datePublic));
//            }
//            System.out.println();
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    public void printAll() {
        for (ItemRss rss : rsses) {
            rss.printInfo();
        }
    }

    public void readDataRss24H(String link) {
        try {
            URL url = new URL(link);
            InputStream in = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            for (int i = 0; i < 16; i++) {
                rd.readLine();
            }

            while (true) {
                String line = rd.readLine();
                if ( line == null || line.startsWith("<link>")){
                    break;
                }
                String title = rd.readLine();
                if (title.equals("<title>")) {
                    title = rd.readLine();
                    rd.readLine();
                } else {
                    title = title.replace("<title>", "");
                    title = title.replace("</title>", "");
                }
                rd.readLine();
                rd.readLine();
                String description = rd.readLine();
                String imageLink = null;
                int indexImage = description.indexOf("src='h");
                if (indexImage > 0) {
                    imageLink = description.substring(indexImage + "src='".length());
                    imageLink = imageLink.substring(0,
                            imageLink.indexOf("' alt"));
                }

                int index = description.indexOf("alt='");
                description = description.substring(index + "alt='".length());
                int indexEnd = description.indexOf("' />");
                description = description.substring(0, indexEnd);
                rd.readLine();
                rd.readLine();
                String publicDate = rd.readLine();
                publicDate = publicDate.replace("<pubDate>", "");
                publicDate = publicDate.replace("</pubDate>", "");
                String htmlLink = rd.readLine();
                htmlLink = htmlLink.replace("<link>", "");
                htmlLink = htmlLink.replace("</link>", "");
                rd.readLine();
                rd.readLine();

                rsses.add(new ItemRss(title, description, imageLink, htmlLink, publicDate));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
