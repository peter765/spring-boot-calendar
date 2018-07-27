package com.example.calendar.controller;


import com.example.calendar.exception.ResourceNotFoundException;
import com.example.calendar.model.Event;
import com.example.calendar.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    // Get All Events
    @GetMapping("/Events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Create a new Event
    @PostMapping("/Events")
    public Event createEvent(@Valid @RequestBody Event Event) {
        return eventRepository.save(Event);
    }

    // Get a Single Event
    // Get a Single Event
    @GetMapping("/Events/{id}")
    public Event getEventById(@PathVariable(value = "id") Long EventId) {
        return eventRepository.findById(EventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", EventId));
    }

    // Update a Event
    @PutMapping("/Events/{id}")
    public Event updateEvent(@PathVariable(value = "id") Long EventId,
                           @Valid @RequestBody Event eventDetails) {

        Event event = eventRepository.findById(EventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", EventId));

        event.setTitle(eventDetails.getTitle());
        event.setContent(eventDetails.getContent());

        Event updatedEvent = eventRepository.save(event);
        return updatedEvent;
    }

    // Delete a Event
    @DeleteMapping("/Events/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable(value = "id") Long EventId) {
        Event event = eventRepository.findById(EventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", EventId));

        eventRepository.delete(event);

        return ResponseEntity.ok().build();
    }
}
