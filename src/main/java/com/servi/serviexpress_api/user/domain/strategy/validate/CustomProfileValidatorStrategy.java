package com.servi.serviexpress_api.user.domain.strategy.validate;

import com.servi.serviexpress_api.user.domain.exception.CustomerDataRequiredException;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;

public class CustomProfileValidatorStrategy implements ProfileValidatorStrategy {
    @Override
    public void validate(UserProfileData profileData) {
        if (profileData.customer() == null || profileData.employee() != null) {
            throw new CustomerDataRequiredException();
        }
    }

    @Override
    public Role getValidator() {
        return Role.CUSTOMER;
    }
}
