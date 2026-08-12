package com.reticket.backend.controller;

import com.reticket.backend.service.EventService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reticket.backend.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import com.reticket.backend.dto.CreateEventRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.reticket.backend.dto.UpdateEventRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService; // este service me lo pasa Spring
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody CreateEventRequest request) {
        Event createdEvent = eventService.createEvent(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdEvent);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody UpdateEventRequest request) {
        return eventService.updateEvent(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
