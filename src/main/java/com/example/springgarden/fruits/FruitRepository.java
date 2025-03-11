package com.example.springgarden.fruits;
import java.util.*;



import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    //Find Flowers by there id
    Optional<Fruit> findById(Long id);

    //Delete Flower by id

}
