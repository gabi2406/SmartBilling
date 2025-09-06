package org.smartbilling.dto;

public record CantonDTO(
        Long id,
        String name,
        Long provinceId
) {}