package com.servi.serviexpress_api.user.infrastructure.config;

import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategy;
import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategyFactory;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategy;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategyFactory;
import com.servi.serviexpress_api.user.domain.strategy.validate.ProfileValidatorStrategy;
import com.servi.serviexpress_api.user.domain.strategy.validate.ProfileValidatorStrategyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProfileStrategyConfig {

    @Bean
        public ProfileCreationStrategyFactory profileCreationStrategyFactory(List<ProfileCreationStrategy> creationStrategies) {
        return new ProfileCreationStrategyFactory(creationStrategies);
    }

    @Bean
    public ProfileUpdateStrategyFactory profileUpdateStrategyFactory(List<ProfileUpdateStrategy> updateStrategies) {
        return new ProfileUpdateStrategyFactory(updateStrategies);
    }

    @Bean
    public ProfileValidatorStrategyFactory profileValidatorStrategyFactory(List<ProfileValidatorStrategy> profileValidatorStrategies) {
        return new ProfileValidatorStrategyFactory(profileValidatorStrategies);
    }
}
