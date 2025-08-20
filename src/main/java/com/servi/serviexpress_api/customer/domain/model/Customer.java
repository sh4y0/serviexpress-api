package com.servi.serviexpress_api.customer.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private UUID id;
    private String address;
    private LocalDateTime createdAt;

    public void updateProfile(Customer customerData) {
        this.address = customerData.getAddress();
    }
}
