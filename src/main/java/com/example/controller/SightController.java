package com.example.controller;

import com.example.entity.Sight;
import com.example.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.example.model.KeelungSightsCrawler.regions;

@RestController
public class SightController {
    @Autowired
    private SightService sightService;

    @GetMapping("/SightAPI")
    public ResponseEntity<List<Sight>> getSight(
            @RequestParam(value = "zone", required = false) String zone
    ) {
        if(zone == null || !isValid(zone)) {
            System.out.println("zone is not valid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<Sight> sights = sightService.getSightsByZone(zone+"區");
        System.out.println("zone : " + zone);
        return ResponseEntity.status(HttpStatus.OK).body(sights);
    }

    boolean isValid(String zone) {
        for (String region : regions) {
            if(zone.equals(region)){
                return true;
            }
        }
        return false;
    }
}
