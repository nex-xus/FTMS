package com.ftms.DTO;

import java.time.LocalDate;

public record FMSRequestDTO(
        String nameOfFunding,
        LocalDate startDate,
        LocalDate endDate
) {
}
