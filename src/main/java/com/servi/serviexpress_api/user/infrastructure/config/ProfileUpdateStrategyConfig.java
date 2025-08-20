package com.servi.serviexpress_api.user.infrastructure.config;

import com.servi.serviexpress_api.user.domain.strategy.update.CustomerProfileUpdateStrategy;
import com.servi.serviexpress_api.user.domain.strategy.update.EmployeeProfileUpdateStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProfileUpdateStrategyConfig {

    @Bean
    public EmployeeProfileUpdateStrategy employeeProfileUpdateStrategy() {
        return new EmployeeProfileUpdateStrategy();
    }

    @Bean
    CustomerProfileUpdateStrategy customerProfileUpdateStrategy() {
        return new CustomerProfileUpdateStrategy();
    }
}
