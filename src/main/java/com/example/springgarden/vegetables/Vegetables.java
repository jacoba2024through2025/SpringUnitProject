package com.example.springgarden.vegetables;



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
    private Long vegetables_id;
    /// /////////////////////////////////////////////////////////////
    public Vegetables(Long fruit_id, String name, String description) {
        this.vegetables_id = fruit_id;
        this.name = name;
        this.description = description;
    }
    /// /////////////////////////////////////////
    public Vegetables(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Vegetables() {

    }


    public String getVegetableName(){return name;}

    public void setVegetableName(String name){this.name=name;}

    public String getDescription() {return description;}

    public void setDescription(String description){this.description=description;}

    public Long getVegetable_id() {return vegetables_id;}

    public void setVegetable_id(Long fruit_id) {this.vegetables_id=vegetables_id;}


    @Override
    public String toString() {
        return "Vegetable{" +
                "Vegetable_id=" + vegetables_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
