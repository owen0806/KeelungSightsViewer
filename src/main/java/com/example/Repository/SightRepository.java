package com.example.Repository;

import com.example.Entity.Sight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SightRepository {
    HashMap<String, Sight[]> repository = new HashMap<>();

    public Sight[] getSights(String zone) {
        return repository.get(zone);
    }

    public void putSights(String zone, Sight[] sights) {
        repository.put(zone, sights);
    }
}
