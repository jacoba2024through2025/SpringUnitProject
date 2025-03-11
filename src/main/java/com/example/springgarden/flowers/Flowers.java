package com.example.springgarden.flowers;

import com.example.springgarden.plants.Plants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Flowers {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(columnDefinition = "TEXT")
 private String daily_nurturing;

 @Column(columnDefinition = "TEXT")
 private String gardening_tips;

 @JsonIgnore
 @ManyToOne
 @JoinColumn(name = "plant_id")
 private Plants plants;

 public Long getId() {
     return id;
 }
 public void setId(Long id) {
     this.id = id;
 }
 public String getDaily_nurturing() {
     return daily_nurturing;
 }
 public void setDaily_nurturing(String daily_nurturing) {
     this.daily_nurturing = daily_nurturing;
 }
 public String getGardening_tips() {
     return gardening_tips;
 }

 public void setGardening_tips(String gardening_tips) {
     this.gardening_tips = gardening_tips;
 }
 public Plants getPlants() {
     return plants;
 }
 public void setPlants(Plants plants) {
     this.plants = plants;
 }
}
