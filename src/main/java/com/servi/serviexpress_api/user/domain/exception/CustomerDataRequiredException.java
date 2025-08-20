package com.servi.serviexpress_api.user.domain.exception;

import static com.servi.serviexpress_api.utils.ErrorCatalog.CUSTOMER_DATA_REQUIRED;

public class CustomerDataRequiredException extends BaseException {
    public CustomerDataRequiredException() {
        super(CUSTOMER_DATA_REQUIRED);
    }
}
