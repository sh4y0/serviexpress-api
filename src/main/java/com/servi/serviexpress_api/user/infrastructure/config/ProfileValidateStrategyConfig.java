package com.servi.serviexpress_api.user.infrastructure.config;


import com.servi.serviexpress_api.user.domain.strategy.validate.CustomProfileValidatorStrategy;
import com.servi.serviexpress_api.user.domain.strategy.validate.EmployeeProfileValidatorStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProfileValidateStrategyConfig {

    @Bean
    public EmployeeProfileValidatorStrategy employeeProfileValidatorStrategy() {
        return new EmployeeProfileValidatorStrategy();
    }

    @Bean
    public CustomProfileValidatorStrategy customProfileValidatorStrategy() {
        return new CustomProfileValidatorStrategy();
    }
}
