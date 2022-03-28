package com.example.demo.employee.service;

import com.example.demo.employee.dao.EmployeeRepository;
import com.example.demo.employee.entity.Employee;
import com.example.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long studentId) {
        boolean exist = employeeRepository.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("id does not exist");
        }
        employeeRepository.deleteById(studentId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String name, String email){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException(
                "student does not exist"
        ));
        if( name != null && !Objects.equals(employee.getName(),name)){
            employee.setName(name);
        }
        if( email != null && !Objects.equals(employee.getEmail(),email)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            employee.setEmail(email);
        }
        employeeRepository.save(employee);
    }

    public void updateEmployeeName(Long id, String name){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "student does not exist"
        ));
        if( name != null && !Objects.equals(employee.getName(),name)){
            employee.setName(name);
        }
        employeeRepository.save(employee);
    }
}

