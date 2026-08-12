package com.reticket.backend.dto;

import com.reticket.backend.model.EventCategory;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateEventRequest(

        @NotBlank
        String name,

        @NotBlank
        String venue,

        @NotBlank
        String city,

        @NotNull
        @Future
        LocalDateTime date,

        @NotNull
        EventCategory category

) {
}