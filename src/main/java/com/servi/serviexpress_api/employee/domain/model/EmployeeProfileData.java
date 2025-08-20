package com.servi.serviexpress_api.employee.domain.model;

public record EmployeeProfileData(
        String dni,
        String dniFrontImageUrl,
        String dniBackImageUrl,
        String criminalRecordUrl,
        String profileDescription,
        String signatureUrl,
        boolean active,
        boolean available
) {}
