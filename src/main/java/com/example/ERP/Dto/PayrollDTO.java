package com.example.ERP.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayrollDTO {
    private Long id;
    private LocalDate payrollDate;
    private BigDecimal amount;
    private Long employeeId;
}
