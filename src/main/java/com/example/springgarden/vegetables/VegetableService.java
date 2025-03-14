package com.example.springgarden.vegetables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VegetableService {
    @Autowired
    private VegetablesRepository vegetablesRepository;

    public List<Vegetables> getAllVegetables() {
        return vegetablesRepository.findAll();
    }

    public Vegetables getVegetableById(Long id) {
        return vegetablesRepository.findById(id).orElseThrow(() -> new RuntimeException("Flower not found"));
    }
}
