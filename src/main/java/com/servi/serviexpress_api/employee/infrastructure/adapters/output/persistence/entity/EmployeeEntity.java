package com.servi.serviexpress_api.employee.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true)
    private String dni;

    private String dniBackImageUrl;
    private String dniFrontImagenUrl;
    private String criminalRecordUrl;
    private String profileDescription;
    private String signatureUrl;
    private boolean active;
    private boolean available;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
