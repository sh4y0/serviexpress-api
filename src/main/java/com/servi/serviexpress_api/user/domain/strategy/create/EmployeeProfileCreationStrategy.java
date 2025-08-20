package com.servi.serviexpress_api.user.domain.strategy.create;

import com.servi.serviexpress_api.employee.domain.model.Employee;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;


public class EmployeeProfileCreationStrategy implements ProfileCreationStrategy {

    @Override
    public void createProfile(User user) {
        user.setEmployee(new Employee());
    }

    @Override
    public Role getStrategyRole() {
        return Role.EMPLOYEE;
    }
}
