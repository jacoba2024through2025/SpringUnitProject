package com.example.springgarden.springevents;


import com.example.springgarden.plants.Plants;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpringEventsService {
    @Autowired
    private SpringRepository springRepository;

    public List<SpringEvents> getAllSpringEvents() {
        return springRepository.findAll();
    }

    public SpringEvents getSpringEventById(Long id) {
        return springRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    public List<SpringEvents> getSpringEventsbyName(String name) {
        return springRepository.findByName(name);
    }
}
