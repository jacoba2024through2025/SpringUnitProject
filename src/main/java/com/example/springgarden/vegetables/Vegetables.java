package com.example.springgarden.vegetables;



import com.example.springgarden.plants.Plants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Vegetables {
    @Id
    @SequenceGenerator(
            name = "vegetables_sequence",
            sequenceName = "vegetables_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vegetables_sequence"
    )
    private String name;
    private String description;
    private String daily_nurturing;
    private Long vegetables_id;
    private String gardening_tips;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plants plants;
    /// /////////////////////////////////////////////////////////////
    public Vegetables(Long fruit_id, String name, String description, String daily_nurturing, String gardening_tips) {
        this.vegetables_id = fruit_id;
        this.name = name;
        this.description = description;
        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
    }
    /// /////////////////////////////////////////
    public Vegetables(String description, String name, String daily_nurturing, String gardening_tips) {
        this.description = description;
        this.name = name;
        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
    }

    public Vegetables() {

    }


    public String getVegetableName(){return name;}

    public void setVegetableName(String name){this.name=name;}

    public String getDescription() {return description;}

    public void setDescription(String description){this.description=description;}

    public Long getVegetable_id() {return vegetables_id;}

    public void setVegetable_id(Long fruit_id) {this.vegetables_id=vegetables_id;}

    public void setDaily_nurturing(String daily_nurturing){this.daily_nurturing=daily_nurturing;}
    public String getDaily_nurturing(){return daily_nurturing;}
    public String getGardening_tips(){return gardening_tips;}
    public void setGardening_tips(String gardening_tips){this.gardening_tips=gardening_tips;}

    public Plants getPlants() {return plants;}
    public void setPlants(Plants plants) {this.plants=plants;}


    @Override
    public String toString() {
        return "Vegetable{" +
                "Vegetable_id=" + vegetables_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", daily_nurturing='" + daily_nurturing + '\'' +
                ", gardening_tips='" + gardening_tips + '\'' +
                '}';
    }
}
