package com.servi.serviexpress_api.user.domain.model;

import com.servi.serviexpress_api.customer.domain.model.Customer;
import com.servi.serviexpress_api.employee.domain.model.Employee;

public record UserProfileData(String name,
                              String lastName,
                              String profileImageUrl,
                              String phone,
                              double latitude,
                              double longitude,
                              Employee employee,
                              Customer customer) {
}
