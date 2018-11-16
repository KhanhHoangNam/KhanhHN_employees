package com.codegym.employee.service;

import com.codegym.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findAllByFullNameContaining(String fullName, Pageable pageable);

}
