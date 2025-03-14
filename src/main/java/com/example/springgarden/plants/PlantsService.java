package com.example.springgarden.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;

    // Fetch all plants
    public List<Plants> getAllPlants() {
        return plantsRepository.findAll();
    }

    // Fetch plant by ID
    public Plants getPlantById(Long id) {
        return plantsRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    // Fetch plant by name
    public List<Plants> getPlantByName(String name) {
        return plantsRepository.findByName(name);
    }
}

