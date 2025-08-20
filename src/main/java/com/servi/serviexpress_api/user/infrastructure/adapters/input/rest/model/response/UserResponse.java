package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.response;

import com.servi.serviexpress_api.customer.infrastructure.adapters.input.rest.model.request.CustomerProfileRequest;
import com.servi.serviexpress_api.employee.infrastructure.adapters.input.rest.model.response.EmployeeProfileResponse;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.annotation.MaskData;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id;
    private String userName;
    private String name;
    private String lastName;
    private String profileImageUrl;
    @MaskData
    private String email;
    @MaskData
    private String phone;
    private LocalDateTime createdAt;
    private boolean completeProfile;
    private double latitude;
    private double longitude;
    @Enumerated(EnumType.STRING)
    private Role role;
    private EmployeeProfileResponse employee;
    private CustomerProfileRequest customer;
}
