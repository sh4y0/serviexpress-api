package com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.mapper;

import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserPersisnteceMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
    List<User> toUserList(List<UserEntity> userEntityList);
}
