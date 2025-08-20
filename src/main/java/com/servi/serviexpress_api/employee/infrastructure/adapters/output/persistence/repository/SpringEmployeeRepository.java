package com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.repository;

import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringEmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}
