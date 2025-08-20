package com.servi.serviexpress_api.user.domain.strategy.update;

import com.servi.serviexpress_api.user.application.ports.input.CompleteProfileCommand;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;

public interface ProfileUpdateStrategy {

    void updateProfileDetails(User user, UserProfileData userProfileData);
    Role getApplicableRole();
}
