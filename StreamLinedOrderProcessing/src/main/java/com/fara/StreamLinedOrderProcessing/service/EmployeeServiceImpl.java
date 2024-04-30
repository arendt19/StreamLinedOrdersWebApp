package com.fara.StreamLinedOrderProcessing.service;

import com.fara.StreamLinedOrderProcessing.model.Employee;
import com.fara.StreamLinedOrderProcessing.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
            existingEmployee.setJob(updatedEmployee.getJob());
            existingEmployee.setPhone(updatedEmployee.getPhone());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        } else {
            return false;
        }
    }
}
