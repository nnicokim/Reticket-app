package com.reticket.backend.exception;

public class VenueNotFoundException extends RuntimeException {

    public VenueNotFoundException(Long id) {
        super("Venue with id " + id + " was not found");
    }
}