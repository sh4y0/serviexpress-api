package com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.mapper;

import com.servi.serviexpress_api.employee.domain.model.Employee;
import com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersistenceEmployeeMapper {

    Employee toEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity toEmployeeEntity(Employee employee);
}
