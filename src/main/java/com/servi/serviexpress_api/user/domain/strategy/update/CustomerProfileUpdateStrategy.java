package com.servi.serviexpress_api.user.domain.strategy.update;

import com.servi.serviexpress_api.customer.domain.model.Customer;
import com.servi.serviexpress_api.user.domain.exception.CustomerDataRequiredException;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerProfileUpdateStrategy implements ProfileUpdateStrategy {

    @Override
    public void updateProfileDetails(User user, UserProfileData userRequest) {
        Customer customer = userRequest.customer();
        if (customer == null) {
            throw new CustomerDataRequiredException();
        }

        user.getCustomer().updateProfile(customer);

    }

    @Override
    public Role getApplicableRole() {
        return Role.CUSTOMER;
    }
}
