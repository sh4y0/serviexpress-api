package com.servi.serviexpress_api.user.domain.exception;

import static com.servi.serviexpress_api.utils.ErrorCatalog.EMPLOYEE_DATA_REQUIRED;

public class EmployeeDataRequiredException extends BaseException {
    public EmployeeDataRequiredException() {
        super(EMPLOYEE_DATA_REQUIRED);
    }
}
