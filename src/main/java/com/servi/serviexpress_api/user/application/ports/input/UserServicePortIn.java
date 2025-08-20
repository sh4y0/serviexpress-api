package com.servi.serviexpress_api.user.application.ports.input;

import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;

import java.util.List;

public interface UserServicePortIn {
    User findById(String id);
    List<User> findAll();
    User save(User user);
    User completeUserProfile(String id, UserProfileData userProfileData);
    void deleteById(String id);
}
