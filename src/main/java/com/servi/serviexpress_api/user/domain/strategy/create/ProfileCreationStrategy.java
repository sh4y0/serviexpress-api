package com.servi.serviexpress_api.user.domain.strategy.create;

import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;


public interface ProfileCreationStrategy {

    void createProfile(User user);
    Role getStrategyRole();
}
