package com.servi.serviexpress_api.employee.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private UUID id;
    private String dni;
    private String dniBackImageUrl;
    private String dniFrontImagenUrl;
    private String criminalRecordUrl;
    private String profileDescription;
    private String signatureUrl;
    private boolean active;
    private boolean available;
    private LocalDateTime createdAt;
    //private Category categoryId;

    public void updateProfile(Employee profileData) {
        this.dni = profileData.getDni();
        this.dniFrontImagenUrl = profileData.getDniFrontImagenUrl();
        this.dniBackImageUrl = profileData.getDniBackImageUrl();
        this.criminalRecordUrl = profileData.getCriminalRecordUrl();
        this.profileDescription = profileData.getProfileDescription();
        this.signatureUrl = profileData.getSignatureUrl();
        this.active = profileData.isActive();
        this.available = profileData.isAvailable();
    }

}
