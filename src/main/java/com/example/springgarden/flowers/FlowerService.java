package com.example.springgarden.flowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    public List<Flowers> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public Flowers getFlowerById(Long id) {
        return flowerRepository.findById(id).orElseThrow(() -> new RuntimeException("Flower not found"));
    }
}

