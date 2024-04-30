package com.fara.StreamLinedOrderProcessing.controller;

import com.fara.StreamLinedOrderProcessing.model.Employee;
import com.fara.StreamLinedOrderProcessing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "New employee added successfully";
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public String updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(employeeId, updatedEmployee);
        if (employee != null) {
            return "Employee updated successfully";
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if (deleted) {
            return "Employee deleted successfully";
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }
}
