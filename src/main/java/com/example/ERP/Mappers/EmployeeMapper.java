package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.EmployeeDTO;
import com.example.ERP.Models.Employee;
import com.example.ERP.Models.Payroll;

@Component
public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getPayrolls() != null ? employee.getPayrolls().stream().map(Payroll::getId).collect(Collectors.toList()) : null
        );
    }

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        // payrolls should be set by service layer or ORM relationships
        return employee;
    }
}
