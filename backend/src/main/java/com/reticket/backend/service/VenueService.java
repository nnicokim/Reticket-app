package com.reticket.backend.service;

import com.reticket.backend.dto.CreateVenueRequest;
import com.reticket.backend.exception.VenueNotFoundException;
import com.reticket.backend.model.Venue;
import com.reticket.backend.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException(id));
    }

    public Venue createVenue(CreateVenueRequest request) {
        Venue venue = new Venue(
                null,
                request.name(),
                request.address(),
                request.city(),
                request.capacity()
        );

        return venueRepository.save(venue);
    }
}