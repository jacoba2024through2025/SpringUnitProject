package com.example.springgarden.vegetables;

import com.example.springgarden.plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springgarden.plants.PlantsRepository;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetablesController {
    @Autowired
    private VegetablesRepository vegetablesRepository;
    @Autowired
    private PlantsRepository plantsRepository;

    @PostMapping
    public Vegetables createVegetable(@RequestBody Vegetables vegetables) {
        return vegetablesRepository.save(vegetables);
    }

    //Grab all created plants
    @GetMapping
    public List<Vegetables> getAllVegetables() {
        return vegetablesRepository.findAll();
    }

    //Grab an existing plant by id
    @GetMapping("/{id}")
    public Vegetables getVegetablesById(@PathVariable Long id) {
        return vegetablesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veggie not found"));
    }



    //Update an existing vegetable
    @PutMapping("/{id}")
    public Vegetables updateVegetable(@PathVariable Long id, @RequestBody Vegetables updatedVegetables) {
        Vegetables existingVegetable = vegetablesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));


        existingVegetable.setGardening_tips(updatedVegetables.getGardening_tips());
        existingVegetable.setDaily_nurturing(updatedVegetables.getDaily_nurturing());
        return vegetablesRepository.save(updatedVegetables);
    }





    @DeleteMapping
    public void deleteFlower(@PathVariable Long id) {
        vegetablesRepository.deleteById(id);
    }

    //Add Flower to plant
    @PutMapping("/{vegetableId}/plants/{plantId}")
    public Vegetables addPostToUser(@PathVariable Long vegetableId, @PathVariable Long plantId) {


        Vegetables vegetables = vegetablesRepository.findById(vegetableId)
                .orElseThrow(() -> new RuntimeException("Vegetable not found"));


        Plants plants = plantsRepository.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        vegetables.setPlants(plants);



        if (!plants.getVegetables().contains(vegetables)) {
            plants.getVegetables().add(vegetables);
        }


        vegetablesRepository.save(vegetables);
        plantsRepository.save(plants);

        return vegetables;
    }
}
