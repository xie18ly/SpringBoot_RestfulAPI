package com.example.demo.employee.config;

import com.example.demo.employee.dao.EmployeeRepository;
import com.example.demo.employee.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository repository){
        return args -> {
            Employee e1 = new Employee(
                    "EmployeeA",
                    "A@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Employee e2 = new Employee(
                    "EmployeeB",
                    "B@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            repository.saveAll(List.of(e1,e2));
        };

    }
}
