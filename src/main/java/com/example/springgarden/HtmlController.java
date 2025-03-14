package com.example.springgarden;
import com.example.springgarden.fruits.Fruit;
import com.example.springgarden.fruits.FruitService;
import com.example.springgarden.vegetables.VegetableService;
import com.example.springgarden.vegetables.Vegetables;
import com.example.springgarden.flowers.FlowerService;
import com.example.springgarden.flowers.Flowers;
import com.example.springgarden.plants.PlantsService;
import com.example.springgarden.plants.Plants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HtmlController {

    @Autowired
    private PlantsService plantsService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private VegetableService vegetablesService;
    @Autowired
    private FruitService fruitService;

    @GetMapping("/home")
    public String home(Model model) {
        // Fetch all plants or specific plant data
        List<Plants> plantsList = plantsService.getAllPlants();

        // Fetch all flowers
        List<Flowers> flowersList = flowerService.getAllFlowers();

        List<Vegetables> vegetablesList = vegetablesService.getAllVegetables();

        List<Fruit> fruitsList = fruitService.getAllFruits();

        // Add plants and flowers data to the model
        model.addAttribute("plants", plantsList);
        model.addAttribute("flowers", flowersList);  // Pass flowers to the model
        model.addAttribute("vegetables", vegetablesList);
        model.addAttribute("fruits", fruitsList);
        // If you just want to pass the name of a specific plant, e.g., the first one
        if (!plantsList.isEmpty()) {
            model.addAttribute("name", plantsList.get(0).getName()); // Passing the first plant's name
        } else {
            model.addAttribute("name", "John");
        }

        return "index"; // This corresponds to src/main/resources/templates/index.html
    }
}


