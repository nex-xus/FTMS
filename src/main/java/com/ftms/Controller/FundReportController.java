package com.ftms.Controller;

import com.ftms.DTO.FundReportRequestDTO;
import com.ftms.DTO.FundReportResponseDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Service.FundReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class FundReportController {
    private final FundReportService fundReportService;

    @Autowired
    public FundReportController(FundReportService fundReportService) {
        this.fundReportService = fundReportService;
    }

    @GetMapping("/funds/{userId}")
    public ResponseEntity<List<FundResponseDTO>> fundReportByUserId(
            @RequestBody FundReportRequestDTO reportRequestDTO,
            @PathVariable Long userId
    ) {
     return ResponseEntity.ok(fundReportService.generateAndGetReport(userId, reportRequestDTO.month(), reportRequestDTO.year()));
    }
}
