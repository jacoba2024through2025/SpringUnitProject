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
    private Long vegetables_id;
    private String veggie_name;

    @Column(columnDefinition = "TEXT")
    private String daily_nurturing;


    @Column(columnDefinition = "TEXT")
    private String gardening_tips;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plants plants;
    /// /////////////////////////////////////////////////////////////
    public Vegetables(Long fruit_id,String daily_nurturing, String gardening_tips, String veggie_name) {
        this.vegetables_id = fruit_id;
        this.veggie_name = veggie_name;


        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
    }
    /// /////////////////////////////////////////
    public Vegetables(String daily_nurturing, String gardening_tips, String veggie_name) {

        this.daily_nurturing = daily_nurturing;
        this.gardening_tips = gardening_tips;
        this.veggie_name = veggie_name;
    }

    public Vegetables() {

    }


    public String getVeggie_name() {
        return veggie_name;
    }
    public void setVeggie_name(String veggie_name) {
        this.veggie_name = veggie_name;
    }

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

                ", daily_nurturing='" + daily_nurturing + '\'' +
                ", gardening_tips='" + gardening_tips + '\'' +
                '}';
    }
}
