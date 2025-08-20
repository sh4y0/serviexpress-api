package com.servi.serviexpress_api.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    USER_NOT_FOUND("ERR_USER_001", "User not found."),
    INVALID_USER("ERR_USER_002", "Validation failed for User creation request."),

    USER_ALREADY_EXISTS("ERR_USER_003", "User already exists"),
    USER_PROFILE_COMPLETED("ERR_USER_004", "Profile already is complete"),

    EMPLOYEE_DATA_REQUIRED("ERR_EMPLOYEE_001", "Employee profile data is required for this role."),
    CUSTOMER_DATA_REQUIRED("ERR_CUSTOMER_001", "Customer profile data is required for this role."),

    GENERIC_ERROR("ERR_SYS_001", "An unexpected error occurred. Please contact support.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
