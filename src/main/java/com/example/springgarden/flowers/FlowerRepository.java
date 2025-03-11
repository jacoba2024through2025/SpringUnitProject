package com.example.springgarden.flowers;
import java.util.*;



import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flowers, Long> {
    //Find Flowers by there id
    Optional<Flowers> findById(Long id);

    //Delete Flower by id

}
