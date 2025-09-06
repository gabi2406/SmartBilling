package org.smartbilling.dto;

public record UserDTO(
        Long id,
        String identification,
        String name,
        String lastname,
        String email,
        int phoneNumber,
        String neighborhoodName
) {}