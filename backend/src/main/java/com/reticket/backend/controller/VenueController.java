package com.reticket.backend.controller;

import com.reticket.backend.dto.CreateVenueRequest;
import com.reticket.backend.model.Venue;
import com.reticket.backend.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id);
    }

    @PostMapping
    public ResponseEntity<Venue> createVenue(@Valid @RequestBody CreateVenueRequest request) {
        Venue venue = venueService.createVenue(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(venue);
    }
}