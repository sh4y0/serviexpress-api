package com.servi.serviexpress_api.user.domain.strategy.create;

import com.servi.serviexpress_api.customer.domain.model.Customer;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;


public class CustomerProfileCreationStrategy implements ProfileCreationStrategy{
    @Override
    public void createProfile(User user) {
        user.setCustomer(new Customer());
    }

    @Override
    public Role getStrategyRole() {
        return Role.CUSTOMER;
    }
}
