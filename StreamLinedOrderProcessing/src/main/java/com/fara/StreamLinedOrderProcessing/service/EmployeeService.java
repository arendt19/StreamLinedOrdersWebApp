package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee updateEmployee(Long employeeId, Employee updatedEmployee);

    boolean deleteEmployee(Long employeeId);
}
