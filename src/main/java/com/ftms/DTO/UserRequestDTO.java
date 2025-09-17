package com.ftms.DTO;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String name
) {}
