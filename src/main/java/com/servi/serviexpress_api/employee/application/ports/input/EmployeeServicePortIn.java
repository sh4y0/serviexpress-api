package com.servi.serviexpress_api.employee.application.ports.input;


import com.servi.serviexpress_api.employee.domain.model.Employee;

import java.util.List;

public interface EmployeeServicePortIn {
    Employee findById(Long id);
    List<Employee> findAll();
    Employee save(Employee user);
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
}
