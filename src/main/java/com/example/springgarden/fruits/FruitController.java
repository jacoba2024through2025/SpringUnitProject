package com.example.springgarden.fruits;
import com.example.springgarden.flowers.Flowers;
import com.example.springgarden.plants.Plants;
import com.example.springgarden.springevents.SpringEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springgarden.plants.PlantsRepository;

import java.util.List;


@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @Autowired
    private PlantsRepository plantsRepository;

    @PostMapping
    public Fruit createFruit(@RequestBody Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    //Grab all created plants
    @GetMapping
    public List<Fruit> getAllFruit() {
        return fruitRepository.findAll();
    }

    //Grab an existing plant by id
    @GetMapping("/{id}")
    public Fruit getfruitById(@PathVariable Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));
    }



    //Update an existing fruit
    @PutMapping("/{id}")
    public Fruit updateFruit(@PathVariable Long id, @RequestBody Fruit updatedFruit) {
        Fruit existingFruit = fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));


        existingFruit.setGardening_tips(updatedFruit.getGardening_tips());
        existingFruit.setDaily_nurturing(updatedFruit.getDaily_nurturing());

        return fruitRepository.save(updatedFruit);
    }





    @DeleteMapping
    public void deleteFlower(@PathVariable Long id) {
        fruitRepository.deleteById(id);
    }
    //Add fruit to plant
    @PutMapping("/{fruitId}/plants/{plantId}")
    public Fruit addPostToUser(@PathVariable Long fruitId, @PathVariable Long plantId) {


        Fruit fruits = fruitRepository.findById(fruitId)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));


        Plants plants = plantsRepository.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        fruits.setPlants(plants);



        if (!plants.getFruits().contains(fruits)) {
            plants.getFruits().add(fruits);
        }


        fruitRepository.save(fruits);
        plantsRepository.save(plants);

        return fruits;
    }


}
