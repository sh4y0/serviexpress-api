package com.servi.serviexpress_api.user.domain.strategy.update;

import com.servi.serviexpress_api.employee.domain.model.Employee;
import com.servi.serviexpress_api.user.domain.exception.EmployeeDataRequiredException;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeProfileUpdateStrategy implements ProfileUpdateStrategy {

    @Override
    public void updateProfileDetails(User user,  UserProfileData userProfileData) {
        Employee employee = userProfileData.employee();
        if (employee == null) {
            throw new EmployeeDataRequiredException();
        }
        user.getEmployee().updateProfile(employee);
    }

    @Override
    public Role getApplicableRole() {
        return Role.EMPLOYEE;
    }
}
