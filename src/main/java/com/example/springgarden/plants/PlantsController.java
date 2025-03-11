package com.example.springgarden.plants;

import com.example.springgarden.springevents.SpringEvents;
import com.example.springgarden.springevents.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/plants")
public class PlantsController {
    @Autowired
    private PlantsRepository plantsRepository;

    @PostMapping
    public Plants createPlants(@RequestBody Plants plants) {
        return plantsRepository.save(plants);
    }

    //Grab all created plants
    @GetMapping
    public List<Plants> getAllPlants() {
        return plantsRepository.findAll();
    }

    //Grab an existing plant by id
    @GetMapping("/{id}")
    public Plants getPlantByID(@PathVariable Long id) {
        return plantsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    //Grab an existing plant by name
    @GetMapping("/name")
    public List<Plants> getPlantByName(@RequestParam String name) {
        return plantsRepository.findByName(name);
    }



    @DeleteMapping
    public void deletePlant(@PathVariable Long id) {
        plantsRepository.deleteById(id);
    }


}
