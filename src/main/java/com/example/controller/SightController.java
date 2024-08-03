package com.example.controller;

import com.example.entity.Sight;
import com.example.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SightController {
    @Autowired
    private SightService sightService;

    @GetMapping("/SightAPI")
    public ResponseEntity<List<Sight>> getSight(
            @RequestParam(value = "zone", required = true) String zone
    ) throws IOException {
        List<Sight> sights = sightService.getSightsByZone(zone+"區");

        if(sights.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        System.out.println("zone : " + zone);
        return ResponseEntity.status(HttpStatus.OK).body(sights);
    }
}
