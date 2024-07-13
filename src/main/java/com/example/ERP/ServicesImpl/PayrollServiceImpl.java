package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.PayrollDTO;
import com.example.ERP.Mappers.PayrollMapper;
import com.example.ERP.Models.Payroll;
import com.example.ERP.Repository.PayrollRepository;
import com.example.ERP.Services.PayrollService;


@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public PayrollDTO createPayroll(PayrollDTO payrollDTO) {
        Payroll payroll = PayrollMapper.toEntity(payrollDTO);
        Payroll savedPayroll = payrollRepository.save(payroll);
        return PayrollMapper.toDTO(savedPayroll);
    }

    @Override
    public PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO) {
        Payroll payroll = payrollRepository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
        payroll.setPayrollDate(payrollDTO.getPayrollDate());
        payroll.setAmount(payrollDTO.getAmount());
        Payroll updatedPayroll = payrollRepository.save(payroll);
        return PayrollMapper.toDTO(updatedPayroll);
    }

    @Override
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    @Override
    public PayrollDTO getPayrollById(Long id) {
        Payroll payroll = payrollRepository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
        return PayrollMapper.toDTO(payroll);
    }

    @Override
    public List<PayrollDTO> getAllPayrolls() {
        return payrollRepository.findAll().stream().map(PayrollMapper::toDTO).collect(Collectors.toList());
    }
    
}
