package org.smartbilling.dto;

public record DistrictDTO(
        Long id,
        String name,
        Long cantonId
) {}