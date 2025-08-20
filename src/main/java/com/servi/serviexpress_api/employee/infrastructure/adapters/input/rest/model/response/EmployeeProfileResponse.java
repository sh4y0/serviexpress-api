package com.servi.serviexpress_api.employee.infrastructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileResponse {
    private String dni;
    private String dniBackImageUrl;
    private String dniFrontImagenUrl;
    private String criminalRecordUrl;
    private String profileDescription;
    private String signatureUrl;
    private boolean active;
    private boolean available;
    //private Category categoryId;

}
