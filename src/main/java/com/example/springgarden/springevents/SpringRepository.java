package com.example.springgarden.springevents;
import java.time.LocalDate;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringRepository extends JpaRepository<SpringEvents, Long> {


    // Find events by name
    List<SpringEvents> findByName(String name);

    // Find events by type
    List<SpringEvents> findByType(String type);

    // Find events by their date
    List<SpringEvents> findByStartDateBeforeAndEndDateAfter(LocalDate currentDate, LocalDate currentDateEnd);
}
