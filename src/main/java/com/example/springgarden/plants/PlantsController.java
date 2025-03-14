package com.example.springgarden.plants;

import com.example.springgarden.springevents.SpringEvents;
import com.example.springgarden.springevents.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springgarden.flowers.Flowers;

import java.util.List;


@RestController
@RequestMapping("/plants")
public class PlantsController {
    @Autowired
    private PlantsRepository plantsRepository;

    @Autowired
    private SpringRepository springRepository;

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



    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantsRepository.deleteById(id);
        

    }


    @PutMapping("/{plantId}/addEvent/{eventId}")
    public Plants addSpringEventToPlant(@PathVariable Long plantId, @PathVariable Long eventId) {
        Plants plant = plantsRepository.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));
        SpringEvents springEvent = springRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));


        plant.getSpringEvents().add(springEvent);
        springEvent.getPlants().add(plant);


        plantsRepository.save(plant);
        springRepository.save(springEvent);

        return plant;
    }



}
