package com.example.springgarden.fruits;
import com.example.springgarden.springevents.SpringEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

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


}
