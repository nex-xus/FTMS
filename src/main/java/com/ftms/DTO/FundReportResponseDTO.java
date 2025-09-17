package com.ftms.DTO;

public record FundReportResponseDTO (
        int month,
        int year,
        double target,
        double paid,
        double due
){}
