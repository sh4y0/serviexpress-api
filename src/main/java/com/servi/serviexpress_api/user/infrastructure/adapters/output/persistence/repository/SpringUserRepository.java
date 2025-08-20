package com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.repository;

import com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringUserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
