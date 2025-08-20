package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request;

import com.servi.serviexpress_api.customer.infrastructure.adapters.input.rest.model.request.CustomerProfileRequest;
import com.servi.serviexpress_api.employee.infrastructure.adapters.input.rest.model.request.EmployeeProfileRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank(message = "Field name cannot be empty or null.")
    private String name;

    @NotBlank(message = "Field lastName cannot be empty or null.")
    private String lastName;

    private String profileImageUrl;
    private String phone;
    private double latitude;
    private double longitude;

    @Valid
    private EmployeeProfileRequest employee;

    @Valid
    private CustomerProfileRequest customer;

}
