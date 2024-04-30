package com.fara.StreamLinedOrderProcessing.repository;

import com.fara.StreamLinedOrderProcessing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
