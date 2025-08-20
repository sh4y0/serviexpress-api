package com.servi.serviexpress_api.employee.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileRequest {

    @NotBlank(message = "Field DNI of Employee is required.")
    private String dni;

    //@NotBlank(message = "Field dniBackImageUrl of Employee is required.")
    private String dniBackImageUrl;

    //@NotBlank(message = "Field dniFrontImagenUrl of Employee is required.")
    private String dniFrontImagenUrl;

    //@NotBlank(message = "Field criminalRecordUrl of Employee is required.")
    private String criminalRecordUrl;

    //@NotBlank(message = "Field profileDescription of Employee is required.")
    private String profileDescription;

    private String signatureUrl;
    private boolean active;
    private boolean available;
    //private Category categoryId;

}
