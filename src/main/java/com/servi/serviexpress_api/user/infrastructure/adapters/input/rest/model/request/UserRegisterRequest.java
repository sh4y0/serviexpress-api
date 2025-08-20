package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request;

import com.servi.serviexpress_api.user.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest{

    @NotBlank(message = "The id is mandatory")
    private String id;

    @NotBlank(message = "The userName is mandatory")
    private String userName;

    @NotBlank(message = "The email is mandatory")
    @Email(message = "The given email does not match the pattern")
    private String email;


    @NotNull(message = "The role is mandatory")
    private Role role;
}
