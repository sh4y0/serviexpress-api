package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.mapper;

import com.servi.serviexpress_api.user.application.ports.input.CompleteProfileCommand;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request.UserRegisterRequest;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request.UserUpdateRequest;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.response.UserResponse;
import com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRestMapper {

    User toUser(UserRegisterRequest request);
    UserProfileData toUser(UserUpdateRequest request);
    CompleteProfileCommand toCompleteProfileCommand(UserUpdateRequest request);
    UserResponse toUserResponse(User user);
    UserEntity toUserEntity(User user);
    List<UserResponse> toUserResponseList(List<User> userList);

}