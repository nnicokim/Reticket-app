package com.reticket.backend.model;

import java.time.LocalDateTime;

public class Event {

    private Long id;
    private String name;
    private String venue;
    private String city;
    private LocalDateTime date;
    private EventCategory category;

    public Event(Long id, String name, String venue, String city, LocalDateTime date, EventCategory category) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.city = city;
        this.date = date;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getVenue() {
        return venue;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public EventCategory getCategory() {
        return category;
    }
}