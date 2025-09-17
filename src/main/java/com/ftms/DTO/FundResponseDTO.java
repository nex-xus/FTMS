package com.ftms.DTO;

import java.time.LocalDate;

public record FundResponseDTO (
        Long userId,
        String username,
        LocalDate createdAt,
        double paidAmount,
        double due
){}
