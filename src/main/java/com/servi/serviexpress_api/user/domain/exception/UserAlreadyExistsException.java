package com.servi.serviexpress_api.user.domain.exception;

import static com.servi.serviexpress_api.utils.ErrorCatalog.USER_ALREADY_EXISTS;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException() {
        super(USER_ALREADY_EXISTS);
    }
}
