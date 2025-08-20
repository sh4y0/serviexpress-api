package com.servi.serviexpress_api.user.domain.strategy.validate;

import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;

public interface ProfileValidatorStrategy {
    void validate(UserProfileData profileData);
    Role getValidator();
}
