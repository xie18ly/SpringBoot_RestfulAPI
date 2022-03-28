package com.example.demo.employee.service;

import com.example.demo.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getEmployees();

    void addNewEmployee(Employee employee);

    void deleteEmployee(Long studentId);

    void updateEmployee(Long employeeId, String name, String email);

    void updateEmployeeName(Long id, String name);
}
