package com.servi.serviexpress_api.user.infrastructure.config;

import com.servi.serviexpress_api.user.domain.strategy.create.CustomerProfileCreationStrategy;
import com.servi.serviexpress_api.user.domain.strategy.create.EmployeeProfileCreationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProfileCreateStrategyConfig {

    @Bean
    public EmployeeProfileCreationStrategy employeeProfileCreationStrategy() {
        return new EmployeeProfileCreationStrategy();
    }

    @Bean
    public CustomerProfileCreationStrategy customerProfileCreationStrategy() {
        return new CustomerProfileCreationStrategy();
    }
}
