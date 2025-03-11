package com.example.springgarden.plants;

import com.example.springgarden.flowers.Flowers;
import com.example.springgarden.fruits.Fruit;
import com.example.springgarden.vegetables.Vegetables;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //One to many - Plants - Fruit, Flower, Vegatables
    @OneToMany(mappedBy = "plants")
    private List<Fruit> fruits;
    @OneToMany(mappedBy = "plants")
    private List<Vegetables> vegetables;
    @OneToMany(mappedBy = "plants")
    private List<Flowers> flowers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Vegetables> getVegetables() {
        return vegetables;
    }
    public void setVegetables(List<Vegetables> vegetables) {
        this.vegetables = vegetables;
    }
    public List<Flowers> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flowers> flowers) {
        this.flowers = flowers;
    }

    public List<Fruit> getFruitList() {
        return fruits;
    }
}
