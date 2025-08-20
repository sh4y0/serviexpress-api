package com.servi.serviexpress_api.user.domain.strategy.update;

import com.servi.serviexpress_api.user.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProfileUpdateStrategyFactory {

    private final Map<Role, ProfileUpdateStrategy> strategies = new HashMap<>();

    @Autowired
    public ProfileUpdateStrategyFactory(List<ProfileUpdateStrategy> strategyList) {
        /*this.strategies = strategyList.stream()
                .collect(Collectors.toMap(ProfileUpdateStrategy::getApplicableRole, Function.identity()));*/

        for (ProfileUpdateStrategy strategy : strategyList) {
            strategies.put(strategy.getApplicableRole(), strategy);
        }
    }

    public ProfileUpdateStrategy findStrategy(Role role) {
        return strategies.get(role);
    }

}
