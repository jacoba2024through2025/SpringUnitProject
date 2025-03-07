package com.example.springgarden.springevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class SpringEventsController {
    @Autowired
    private SpringRepository springRepository;

    //Method for creating an event
    @PostMapping
    public SpringEvents createEvent(@RequestBody SpringEvents events) {
        return springRepository.save(events);
    }

    // Get all events
    @GetMapping
    public List<SpringEvents> getAllEvents() {
        return springRepository.findAll();
    }

    // Get a single event by id
    @GetMapping("/{id}")
    public SpringEvents getEventById(@PathVariable Long id) {
        return springRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // Get a single event by name
    @GetMapping("/name")
    public List<SpringEvents> getEventsByName(@RequestParam String name) {
        return springRepository.findByName(name);  // Update method call
    }

    // Get a single event by type
    @GetMapping("/type")
    public List<SpringEvents> getEventsByType(@RequestParam String type) {
        return springRepository.findByType(type);  // Update method call
    }

    // Update an event
    @PutMapping("/{id}")
    public SpringEvents updateEvent(@PathVariable Long id, @RequestBody SpringEvents updatedEvent) {
        SpringEvents existingEvent = springRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setStartDate(updatedEvent.getStartDate());
        existingEvent.setType(updatedEvent.getType());

        return springRepository.save(existingEvent);
    }

    // Delete an event
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        springRepository.deleteById(id);
    }
}

