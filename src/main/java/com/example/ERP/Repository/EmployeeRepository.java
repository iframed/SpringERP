package com.example.ERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ERP.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
