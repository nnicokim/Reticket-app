package com.reticket.backend.service;

import com.reticket.backend.dto.CreateEventRequest;
import com.reticket.backend.dto.UpdateEventRequest;
import com.reticket.backend.exception.EventNotFoundException;
import com.reticket.backend.model.Event;
import com.reticket.backend.model.Venue;
import com.reticket.backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final VenueService venueService;

    public EventService(
            EventRepository eventRepository,
            VenueService venueService
    ) {
        this.eventRepository = eventRepository;
        this.venueService = venueService;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public Event createEvent(CreateEventRequest request) {
        Venue venue = venueService.getVenueById(request.venueId());
        Event event = new Event(
                null,
                request.name(),
                venue,
                request.date(),
                request.category()
        );

        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, UpdateEventRequest request) {
        Event event = getEventById(id);
        Venue venue = venueService.getVenueById(request.venueId());

        event.setName(request.name());
        event.setVenue(venue);
        event.setDate(request.date());
        event.setCategory(request.category());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
}