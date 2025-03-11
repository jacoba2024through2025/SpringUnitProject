package com.example.springgarden.plants;

import com.example.springgarden.plants.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantsRepository extends JpaRepository<Plants, Long> {
    //Find by name
    List<Plants> findByName(String name);

    //Find by description
}
