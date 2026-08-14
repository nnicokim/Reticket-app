package com.reticket.backend.dto;

import com.reticket.backend.model.UserRole;

public record UserResponse(
        Long id,
        String name,
        String email,
        UserRole role
) {
}