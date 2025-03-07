package com.example.springgarden.flowers;

import com.example.springgarden.plants.Plants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Flower {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String daily_nurturing;
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
}
