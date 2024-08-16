package com.example.model;

import com.example.entity.Sight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeelungSightsCrawler {
    private Document document;
    public static final String[] regions = {"七堵", "中山", "中正", "仁愛", "安樂", "信義", "暖暖"};
    private final int maxRetry = 5;
    private final int timeout = 20000;

    public KeelungSightsCrawler() {
        String url = "https://www.travelking.com.tw/tourguide/taiwan/keelungcity/";

        boolean success = false;
        int retryCount = 0;
        while (!success && retryCount < maxRetry) {
            try {
                document = Jsoup.connect(url).timeout(timeout).get();
                success = true;
                System.out.println("Successfully connected to " + url);
            } catch (IOException e) {
                retryCount++;
                System.out.println("Crawler initial timeout. Retry attempt: " + retryCount);
                if(retryCount >= maxRetry) {
                    System.out.println("Max retry attempt reached.");
                    e.printStackTrace();
                }
            }
        }
    }

    public Sight getSight(String link) {
        String url = "https://www.travelking.com.tw" + link;
        Document doc = null;

        boolean success = false;
        int retryCount = 0;
        while(!success && retryCount < maxRetry) {
            try{
                doc = Jsoup.connect(url).timeout(timeout).get();
                success = true;
                System.out.println("Successfully connected to " + url);
            } catch (IOException e) {
                retryCount++;
                System.out.println("Crawler request timeout. Retry attempt: " + retryCount);
                if(retryCount >= maxRetry) {
                    System.out.println("Max retry attempt reached.");
                    System.out.println("Sights is missing.");
                }
            }
        }

        Sight sight = new Sight();

        String sightName = doc.selectXpath("//*[@id=\"point_area\"]/h1/span").text();
        sight.setSightName(sightName);

        String zone = doc.selectXpath("//*[@id=\"content\"]/div/ol/li[5]/a").text();
        sight.setZone(zone);

        String category = doc.selectXpath("//*[@id=\"point_area\"]/cite/span[1]/span[2]").text();
        if(category.isEmpty()) {
            category = "無";
        }
        sight.setCategory(category);

        String photoURL = doc.selectXpath("//*[@id=\"galleria\"]/div[1]/div[1]/div/div[1]/div/img").attr("data-src");
        if(photoURL.isEmpty()) {
            photoURL = "https://www.travelking.com.tw/tourguide/images/map/CHI-City-network-216.jpg";
        }
        sight.setPhotoURL(photoURL);

        Elements textDiv = doc.selectXpath("//*[@id=\"point_area\"]/div[4]");
        textDiv.select("div").remove();
        String description = textDiv.text();
        if(description.isEmpty()) {
            description = sightName;
        }
        sight.setDescription(description);

        String address = doc.selectXpath("//*[@id=\"point_data\"]/div[1]/p/a/span").text();
        if(address.isEmpty()) {
            address = "基隆市" + zone + "區";
        }
        sight.setAddress(address);

        return sight;
    }

    public List<Sight> getItems(String region) {
        ArrayList<Sight> sights = new ArrayList<>();
        for (int i = 0; i < regions.length; i++) {
            if (region.equals(regions[i])) {
                String xpath = String.format("//*[@id=\"guide-point\"]/div/ul[%d]", i+2);
                Elements elements = document.selectXpath(xpath);

                Elements links = elements.select("a");
                for(Element link : links) {
                    sights.add(getSight(link.attr("href")));
                }
                break;
            }
        }
        return sights;
    }
}