package com.servi.serviexpress_api.user.domain.strategy.validate;

import com.servi.serviexpress_api.user.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProfileValidatorStrategyFactory {

    private Map<Role, ProfileValidatorStrategy> strategies = new HashMap<>();

    @Autowired
    public ProfileValidatorStrategyFactory(List<ProfileValidatorStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(ProfileValidatorStrategy::getValidator, Function.identity()));
    }

    public ProfileValidatorStrategy findStrategy(Role role) {
        return strategies.get(role);
    }
}
