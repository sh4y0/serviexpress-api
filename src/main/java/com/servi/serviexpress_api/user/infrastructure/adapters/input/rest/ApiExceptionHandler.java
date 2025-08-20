package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest;

import com.servi.serviexpress_api.user.domain.exception.*;
import com.servi.serviexpress_api.user.domain.model.ErrorResponse;
import com.servi.serviexpress_api.utils.ErrorCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.servi.serviexpress_api.utils.ErrorCatalog.*;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(BaseException businessException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildError(businessException.getError()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmployeeDataRequiredException.class,
                       CustomerDataRequiredException.class})
    public ResponseEntity<ErrorResponse> handleDataRequired(BaseException businessException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildError(businessException.getError()));
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserAlreadyExistsException.class,
                       UserProfileAlreadyCompletedException.class})
    public ResponseEntity<ErrorResponse> handleUserConflict(BaseException businessException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(buildError(businessException.getError()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.builder()
                .code(INVALID_USER.getCode())
                .message(INVALID_USER.getMessage())
                .errors(result.getFieldErrors()
                        .stream()
                        .map(err -> {
                            Map<String,String> errorMap = new HashMap<>();
                            errorMap.put("field", err.getField());
                            errorMap.put("error",err.getDefaultMessage());
                            return  errorMap;
                        })
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericError(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                //.errors(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build());
    }

    private ErrorResponse buildError(ErrorCatalog error) {
        return ErrorResponse.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
