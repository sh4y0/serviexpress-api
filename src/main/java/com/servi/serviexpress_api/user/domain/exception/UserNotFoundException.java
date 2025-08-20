package com.servi.serviexpress_api.user.domain.exception;

import static com.servi.serviexpress_api.utils.ErrorCatalog.USER_NOT_FOUND;

public class UserNotFoundException extends BaseException{

    public UserNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
