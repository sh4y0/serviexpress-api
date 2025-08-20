package com.servi.serviexpress_api.user.domain.strategy.validate;

import com.servi.serviexpress_api.user.domain.exception.EmployeeDataRequiredException;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;

public class EmployeeProfileValidatorStrategy implements ProfileValidatorStrategy {
    @Override
    public void validate(UserProfileData profileData) {
        if (profileData.employee() == null || profileData.customer() != null) {
            throw new EmployeeDataRequiredException();
        }

    }

    @Override
    public Role getValidator() {
        return Role.EMPLOYEE;
    }
}
