package com.example.springgarden.fruits;


import com.example.springgarden.plants.Plants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Fruit {
    @Id
    @SequenceGenerator(
            name = "fruit_sequence",
            sequenceName = "fruit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fruit_sequence"
    )

    private Long fruit_id;
    private String daily_nurturing;
    private String gardening_tips;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plants plants;

/// /////////////////////////////////////////////////////////////
    public Fruit(Long fruit_id,  String daily_nurturing, String gardening_tips) {
        this.fruit_id = fruit_id;

        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
    }
   /// /////////////////////////////////////////
     public Fruit( String daily_nurturing, String gardening_tips) {

        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
    }

    public Fruit() {

    }




    public Long getfruit_id() {return fruit_id;}

    public void setfruit_id(Long fruit_id) {this.fruit_id=fruit_id;}

    public String getDaily_nurturing(){return daily_nurturing;}
    public void setDaily_nurturing(String daily_nurturing){this.daily_nurturing=daily_nurturing;}
    public String getGardening_tips(){return gardening_tips;}
    public void setGardening_tips(String gardening_tips){this.gardening_tips=gardening_tips;}
    public Plants getPlants() {return plants;}
    public void setPlants(Plants plants) {this.plants=plants;}
    @Override
    public String toString() {
        return "Fruit{" +
                "fruit_id=" + fruit_id +

                ", daily_nurturing='" + daily_nurturing + '\'' +
                ", gardening_tips='" + gardening_tips + '\'' +
                ", plants=" + plants +
                '}';
    }
}
