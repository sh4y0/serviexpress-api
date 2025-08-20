package com.servi.serviexpress_api.employee.application.ports.output;


import com.servi.serviexpress_api.employee.domain.model.Employee;
import com.servi.serviexpress_api.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeServicePortOut {

    Optional<Employee> findByUser(User user);
    Optional<Employee> findBy(UUID id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(UUID id);
}
