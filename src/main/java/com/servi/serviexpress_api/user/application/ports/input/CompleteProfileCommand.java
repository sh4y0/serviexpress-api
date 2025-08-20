package com.servi.serviexpress_api.user.application.ports.input;

import com.servi.serviexpress_api.customer.domain.model.CustomerProfileData;
import com.servi.serviexpress_api.employee.domain.model.EmployeeProfileData;
import lombok.*;

@Builder
public record CompleteProfileCommand(String name,
                                     String lastName,
                                     String profileImageUrl,
                                     String phone,
                                     double latitude,
                                     double longitude,
                                     EmployeeProfileData employee,
                                     CustomerProfileData customer) {

}
