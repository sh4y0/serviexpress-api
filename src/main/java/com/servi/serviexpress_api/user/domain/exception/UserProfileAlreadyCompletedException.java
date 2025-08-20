package com.servi.serviexpress_api.user.domain.exception;

import static com.servi.serviexpress_api.utils.ErrorCatalog.USER_PROFILE_COMPLETED;

public class UserProfileAlreadyCompletedException extends BaseException {
    public UserProfileAlreadyCompletedException() {
        super(USER_PROFILE_COMPLETED);
    }
}
