package com.reticket.backend.service;

import com.reticket.backend.dto.CreateUserRequest;
import com.reticket.backend.dto.UserResponse;
import com.reticket.backend.exception.EmailAlreadyExistsException;
import com.reticket.backend.exception.UserNotFoundException;
import com.reticket.backend.model.User;
import com.reticket.backend.model.UserRole;
import com.reticket.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return toResponse(user);
    }

    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(request.email());
        }

        User user = new User(
                null,
                request.name(),
                request.email(),
                request.password(),
                UserRole.USER
        );

        User savedUser = userRepository.save(user);

        return toResponse(savedUser);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}