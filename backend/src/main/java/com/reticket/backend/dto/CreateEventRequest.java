package com.reticket.backend.dto;

import com.reticket.backend.model.EventCategory;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateEventRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Venue id is required")
        Long venueId,

        @NotNull(message = "Date is required")
        @Future(message = "Date must be in the future")
        LocalDateTime date,

        @NotNull(message = "Category is required")
        EventCategory category

) {
}