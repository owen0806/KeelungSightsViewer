package com.example.service;

import com.example.entity.Sight;
import com.example.model.KeelungSightsCrawler;
import com.example.repository.SightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.example.model.KeelungSightsCrawler.regions;

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
            List<Sight> sights = crawler.getItems(region);
            sightRepository.saveAll(sights);
        }
        System.out.println(sightRepository.count());
    }

    public List<Sight> getSightsByZone(String zone) {
        return sightRepository.findByZone(zone);
    }
}
