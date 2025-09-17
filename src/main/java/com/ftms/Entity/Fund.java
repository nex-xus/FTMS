package com.ftms.Entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Table(name = "fund")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdAt;
    private double paidAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Fund(double paidAmount, User user) {
        this.paidAmount = paidAmount;
        this.user = user;
    }
}
