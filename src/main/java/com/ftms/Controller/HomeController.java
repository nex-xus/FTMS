package com.ftms.Controller;

import com.ftms.DTO.FMSRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fms")
public class HomeController {

    @PostMapping
    public void createFundManagementSystem(@RequestBody FMSRequestDTO requestDTO) {

    }
}
