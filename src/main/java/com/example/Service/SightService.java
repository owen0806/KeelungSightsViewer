package com.example.Service;

import com.example.Entity.Sight;
import com.example.KeelungSightsCrawler;
import com.example.Repository.SightRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SightService {
    private final KeelungSightsCrawler crawler;
    private final SightRepository sightRepository;

    public SightService() throws IOException {
        crawler = new KeelungSightsCrawler();
        sightRepository = new SightRepository();
    }

    public Sight[] getSightsByZone(String zone) throws IOException {
        Sight[] sights = sightRepository.getSights(zone);
        if(sights == null) {
            sights = crawler.getItems(zone);
            sightRepository.putSights(zone, sights);
        }
        return sights;
    }
}
