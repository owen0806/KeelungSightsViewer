package com.example.Service;

import com.example.Entity.Sight;
import com.example.KeelungSightsCrawler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SightService {
    private final KeelungSightsCrawler crawler;

    public SightService() throws IOException {
        crawler = new KeelungSightsCrawler();
    }

    public Sight[] getSightsByZone(String zone) throws IOException {
        return crawler.getItems(zone);
    }
}
