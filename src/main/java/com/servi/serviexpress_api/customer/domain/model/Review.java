package com.servi.serviexpress_api.customer.domain.model;

import com.servi.serviexpress_api.employee.domain.model.Employee;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Long id;
    private String comment;
    private double rating;
    private LocalDateTime createdAt;
    private Employee employeeId;
    private Customer customerId;

}
