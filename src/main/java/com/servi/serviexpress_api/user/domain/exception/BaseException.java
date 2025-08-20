package com.servi.serviexpress_api.user.domain.exception;

import com.servi.serviexpress_api.utils.ErrorCatalog;
import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException{
    private final ErrorCatalog error;

    protected BaseException(ErrorCatalog error) {
        super(error.getMessage());
        this.error = error;
    }
}
