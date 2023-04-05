package com.example.asynctask;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MrgItemRss {
    private List<ItemRss> rsses;

    public MrgItemRss() {
        this.rsses = new ArrayList<>();
    }

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
