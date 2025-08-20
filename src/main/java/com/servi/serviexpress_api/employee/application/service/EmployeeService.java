package com.servi.serviexpress_api.employee.application.service;

import com.servi.serviexpress_api.employee.application.ports.input.EmployeeServicePortIn;
import com.servi.serviexpress_api.employee.application.ports.output.EmployeeServicePortOut;
import com.servi.serviexpress_api.employee.domain.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServicePortIn {
    private final EmployeeServicePortOut employeeServicePortOut;

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee save(Employee user) {
        return null;
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
