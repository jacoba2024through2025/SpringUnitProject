package com.example.springgarden.fruits;


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
    private String name;
    private String description;
    private Long fruit_id;
/// /////////////////////////////////////////////////////////////
    public Fruit(Long fruit_id, String name, String description) {
        this.fruit_id = fruit_id;
        this.name = name;
        this.description = description;
    }
   /// /////////////////////////////////////////
     public Fruit(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Fruit() {

    }


    public String getFruitName(){return name;}

    public void setFruitName(String name){this.name=name;}

    public String getDescription() {return description;}

    public void setDescription(String description){this.description=description;}

    public Long getfruit_id() {return fruit_id;}

    public void setfruit_id(Long fruit_id) {this.fruit_id=fruit_id;}


    @Override
    public String toString() {
        return "Fruit{" +
                "fruit_id=" + fruit_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
