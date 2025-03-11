package com.example.springgarden.vegetables;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {
    //Find Flowers by there id
    Optional<Vegetables> findById(Long id);


}
