package com.servi.serviexpress_api.user.domain.strategy.create;

import com.servi.serviexpress_api.user.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileCreationStrategyFactory {

    private final Map<Role, ProfileCreationStrategy> strategies = new HashMap<>();

    @Autowired
    public ProfileCreationStrategyFactory(List<ProfileCreationStrategy> strategyList) {
        for (ProfileCreationStrategy strategy : strategyList) {
            strategies.put(strategy.getStrategyRole(), strategy);
        }
    }

    public ProfileCreationStrategy findStrategy(Role role) {
        ProfileCreationStrategy strategy = strategies.get(role);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy found for role: " + role);
        }
        return strategy;
    }
}
