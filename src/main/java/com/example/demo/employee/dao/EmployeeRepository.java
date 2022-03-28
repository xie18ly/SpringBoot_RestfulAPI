package com.example.demo.employee.dao;

import com.example.demo.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    @Query
    Optional<Employee> findEmployeeByEmail(String email);
}
