package com.reticket.backend.service;

import com.reticket.backend.model.Event;
import com.reticket.backend.model.EventCategory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final List<Event> events = List.of(
            new Event(
                    1L,
                    "Coldplay",
                    "Estadio River Plate",
                    "Buenos Aires",
                    LocalDateTime.of(2026, 11, 15, 21, 0),
                    EventCategory.CONCERT
            ),
            new Event(
                    2L,
                    "Argentina vs Brasil",
                    "Estadio Monumental",
                    "Buenos Aires",
                    LocalDateTime.of(2027, 3, 20, 20, 30),
                    EventCategory.SPORTS
            )
    );

    public List<Event> getAllEvents() {
        return events;
    }

    public Event getEventById(Long id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}