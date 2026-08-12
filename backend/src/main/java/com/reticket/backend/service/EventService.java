package com.reticket.backend.service;

import com.reticket.backend.exception.EventNotFoundException;
import com.reticket.backend.model.Event;
import com.reticket.backend.model.EventCategory;
import com.reticket.backend.dto.CreateEventRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class EventService {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 3L; // a falta de Postgres, por ahora se asigna manualmente el id

    public EventService() {
        events.add(
                new Event(
                        1L,
                        "Coldplay",
                        "Estadio River Plate",
                        "Buenos Aires",
                        LocalDateTime.of(2026, 11, 15, 21, 0),
                        EventCategory.CONCERT
                )
        );

        events.add(
                new Event(
                        2L,
                        "Argentina vs Brasil",
                        "Estadio Monumental",
                        "Buenos Aires",
                        LocalDateTime.of(2027, 3, 20, 20, 30),
                        EventCategory.SPORTS
                )
        );
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public Event getEventById(Long id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public Event createEvent(CreateEventRequest request) {

        Event event = new Event(
                nextId,
                request.name(),
                request.venue(),
                request.city(),
                request.date(),
                request.category()
        );

        nextId++;

        events.add(event);

        return event;
    }
}