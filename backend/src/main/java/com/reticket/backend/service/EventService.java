package com.reticket.backend.service;

import com.reticket.backend.dto.UpdateEventRequest;
import com.reticket.backend.exception.EventNotFoundException;
import com.reticket.backend.model.Event;
import com.reticket.backend.model.EventCategory;
import com.reticket.backend.dto.CreateEventRequest;
import com.reticket.backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public Event createEvent(CreateEventRequest request) {
        Event event = new Event(
                null,
                request.name(),
                request.venue(),
                request.city(),
                request.date(),
                request.category()
        );

        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, UpdateEventRequest request) {
        Event event = getEventById(id);

        event.setName(request.name());
        event.setVenue(request.venue());
        event.setCity(request.city());
        event.setDate(request.date());
        event.setCategory(request.category());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
}