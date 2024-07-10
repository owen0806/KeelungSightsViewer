package com.example;

import com.example.Entity.Sight;

import java.io.IOException;

public class KeelungSightCrawlerTest {
    public static void main(String[] args) throws IOException {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItems("七堵");
        for(Sight s : sights){
            System.out.println(s);
        }
    }
}
