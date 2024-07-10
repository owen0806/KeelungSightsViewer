package com.example.Controller;

import com.example.Entity.Sight;
import com.example.Service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SightController {
    @Autowired
    private SightService sightService;

    @GetMapping("/SightAPI")
    public Sight[] getSight(
            @RequestParam(value = "zone", required = true) String zone
    ) throws IOException {
        return sightService.getSightsByZone(zone);
    }
}
