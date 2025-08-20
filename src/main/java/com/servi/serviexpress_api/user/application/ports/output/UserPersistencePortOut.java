package com.servi.serviexpress_api.user.application.ports.output;

import com.servi.serviexpress_api.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePortOut {
    Optional<User> findById(String id);
    List<User> findAll();
    User save(User user);
    void deleteById(String id);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
