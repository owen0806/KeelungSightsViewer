package com.example.Service;

import com.example.Entity.Sight;
import com.example.KeelungSightsCrawler;
import com.example.Repository.SightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.example.KeelungSightsCrawler.regions;

@Service
public class SightService {
    @Autowired
    private SightRepository sightRepository;
    private final KeelungSightsCrawler crawler;

    public SightService() throws IOException {
        crawler = new KeelungSightsCrawler();
    }

    @PostConstruct
    public void init() throws IOException {
        sightRepository.deleteAll();
        for (String region : regions) {
            Sight[] sights = crawler.getItems(region);
            for (Sight sight : sights) {
                sightRepository.save(sight);
            }
        }
        System.out.println(sightRepository.count());
    }

    public List<Sight> getSightsByZone(String zone) {
        return sightRepository.findByZone(zone);
    }
}
