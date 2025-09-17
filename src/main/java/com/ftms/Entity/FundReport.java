package com.ftms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fund_report")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FundReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int month;
    private int year;

    private double targetAmount;
    private double paidAmount;
    private double dueAmount;
}
