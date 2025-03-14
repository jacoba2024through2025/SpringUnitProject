package com.example.springgarden.fruits;
import com.example.springgarden.flowers.Flowers;
import com.example.springgarden.fruits.FruitRepository;
import com.example.springgarden.vegetables.Vegetables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit not found"));
    }
}
