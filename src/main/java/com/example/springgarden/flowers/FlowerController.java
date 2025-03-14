package com.example.springgarden.flowers;
import com.example.springgarden.plants.Plants;
import com.example.springgarden.plants.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private PlantsRepository plantsRepository;

    @PostMapping
    public Flowers createFlower(@RequestBody Flowers flowers) {
        return flowerRepository.save(flowers);
    }

    //Grab all created plants
    @GetMapping
    public List<Flowers> getAllFlower() {
        return flowerRepository.findAll();
    }

    //Grab an existing plant by id
    @GetMapping("/{id}")
    public Flowers getEventById(@PathVariable Long id) {
        return flowerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));
    }

    //Add Flower to plant
    @PutMapping("/{flowerId}/plants/{plantId}")
    public Flowers addPostToUser(@PathVariable Long flowerId, @PathVariable Long plantId) {


        Flowers flowers = flowerRepository.findById(flowerId)
                .orElseThrow(() -> new RuntimeException("Flower not found"));


        Plants plants = plantsRepository.findById(plantId)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        flowers.setPlants(plants);



        if (!plants.getFlowers().contains(flowers)) {
            plants.getFlowers().add(flowers);
        }


        flowerRepository.save(flowers);
        plantsRepository.save(plants);

        return flowers;
    }

    //Update an existing flower
    @PutMapping("/{id}")
    public Flowers updateFlower(@PathVariable Long id, @RequestBody Flowers updatedFlowers) {
        Flowers existingFlowers = flowerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));


        existingFlowers.setGardening_tips(updatedFlowers.getGardening_tips());
        existingFlowers.setDaily_nurturing(updatedFlowers.getDaily_nurturing());

        return flowerRepository.save(updatedFlowers);
    }

    @DeleteMapping
    public void deleteFlower(@PathVariable Long id) {
        flowerRepository.deleteById(id);
    }


}
