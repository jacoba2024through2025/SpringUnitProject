package com.example.springgarden.plants;

import com.example.springgarden.flowers.Flowers;
import com.example.springgarden.fruits.Fruit;
import com.example.springgarden.springevents.SpringEvents;
import com.example.springgarden.vegetables.Vegetables;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class Plants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "TEXT")
    private String imageFilename;



    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    //One to many - Plants - Fruit, Flower, Vegatables
    @OneToMany(mappedBy = "plants", cascade = CascadeType.REMOVE)
    private List<Fruit> fruits;
    @OneToMany(mappedBy = "plants", cascade = CascadeType.REMOVE)
    private List<Vegetables> vegetables;
    @OneToMany(mappedBy = "plants", cascade = CascadeType.REMOVE)
    private List<Flowers> flowers;
    //Many to many - Plants - Spring Events

    @ManyToMany
    @JoinTable(
            name = "plants_spring_events",  // Join table name
            joinColumns = @JoinColumn(name = "plant_id"), // Foreign key for plants
            inverseJoinColumns = @JoinColumn(name = "spring_event_id") // Foreign key for spring events
    )
    private List<SpringEvents> springEvents;

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

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
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

    public List<SpringEvents> getSpringEvents() {
        return springEvents;
    }
    public void setSpringEvents(List<SpringEvents> springEvents) {
        this.springEvents = springEvents;
    }
}
