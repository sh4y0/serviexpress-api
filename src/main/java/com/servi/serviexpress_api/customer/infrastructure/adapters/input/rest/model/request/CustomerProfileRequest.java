package com.servi.serviexpress_api.customer.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfileRequest {
    @NotBlank(message = "address is required.")
    private String address;
}
