package com.reticket.backend.model;

import java.time.LocalDateTime;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    protected Event() {
    }

    public Event(Long id, String name, Venue venue, LocalDateTime date, EventCategory category) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Venue getVenue() {
        return venue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public EventCategory getCategory() {
        return category;
    }
}