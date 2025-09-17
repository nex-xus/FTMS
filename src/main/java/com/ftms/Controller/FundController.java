package com.ftms.Controller;

import com.ftms.DTO.FundRequestDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Mapper.FundMapper;
import com.ftms.Service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funds")
public class FundController {
    private final FundService fundService;
    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }


    @PostMapping()
    public void addFund(@RequestBody FundRequestDTO requestDTO) {
        fundService.saveFund(requestDTO);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<FundResponseDTO>> getFundsByName (@PathVariable String username) {
        return ResponseEntity.ok(fundService.getFundByName(username));
    }

    @GetMapping("/total")
    public Double getTotalFund() {
        return fundService.getTotalFund();
    }
}