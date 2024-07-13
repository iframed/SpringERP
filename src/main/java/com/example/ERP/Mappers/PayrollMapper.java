package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.PayrollDTO;
import com.example.ERP.Models.Payroll;


@Component
public class PayrollMapper {
    public static PayrollDTO toDTO(Payroll payroll) {
        return new PayrollDTO(
                payroll.getId(),
                payroll.getPayrollDate(),
                payroll.getAmount(),
                payroll.getEmployee() != null ? payroll.getEmployee().getId() : null
        );
    }

    public static Payroll toEntity(PayrollDTO payrollDTO) {
        Payroll payroll = new Payroll();
        payroll.setId(payrollDTO.getId());
        payroll.setPayrollDate(payrollDTO.getPayrollDate());
        payroll.setAmount(payrollDTO.getAmount());
        // employee should be set by service layer or ORM relationships
        return payroll;
    }
}
