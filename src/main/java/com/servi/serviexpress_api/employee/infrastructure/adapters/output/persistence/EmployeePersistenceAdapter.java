package com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence;

import com.servi.serviexpress_api.employee.application.ports.output.EmployeeServicePortOut;
import com.servi.serviexpress_api.employee.domain.model.Employee;
import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.entity.EmployeeEntity;
import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.mapper.PersistenceEmployeeMapper;
import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.repository.SpringEmployeeRepository;
import com.servi.serviexpress_api.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements EmployeeServicePortOut {
    private final SpringEmployeeRepository springEmployeeRepository;
    private final PersistenceEmployeeMapper persistenceEmployeeMapper;

    @Override
    public Optional<Employee> findByUser(User user) {
        return springEmployeeRepository.findById(user.getId()).map(persistenceEmployeeMapper::toEmployee);
    }

    @Override
    public Optional<Employee> findBy(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = persistenceEmployeeMapper.toEmployeeEntity(employee);
        return persistenceEmployeeMapper.toEmployee(springEmployeeRepository.save(employeeEntity));
    }

    @Override
    public void deleteById(UUID id) {

    }
}
