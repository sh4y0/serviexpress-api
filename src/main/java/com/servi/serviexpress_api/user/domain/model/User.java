package com.servi.serviexpress_api.user.domain.model;

import com.servi.serviexpress_api.customer.domain.model.Customer;
import com.servi.serviexpress_api.employee.domain.model.Employee;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String name;
    private String lastName;
    private String profileImageUrl;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private boolean completeProfile;
    private double latitude;
    private double longitude;
    private Role role;
    private Employee employee;
    private Customer customer;
}
