package com.example.demo.employee.controller;

import com.example.demo.employee.service.EmployeeService;
import com.example.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/employee/{id}")
    public void updateEmployee(@PathVariable("id") Long employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId, name, email);
    }

    @PatchMapping("/employees/{id}/{name}")
    public void updateEmployeePartially(@PathVariable Long id, @PathVariable String name) {
        employeeService.updateEmployeeName(id,name);
    }
}
