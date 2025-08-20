package com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence;

import com.servi.serviexpress_api.user.application.ports.output.UserPersistencePortOut;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.mapper.UserPersisnteceMapper;
import com.servi.serviexpress_api.user.infrastructure.adapters.output.persistence.repository.SpringUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePortOut {
    private final SpringUserRepository springUserRepository;
    private final UserPersisnteceMapper persisnteceMapper;

    @Override
    public Optional<User> findById(String id) {
        return springUserRepository.findById(id).map(persisnteceMapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return persisnteceMapper.toUserList(springUserRepository.findAll());
    }

    @Override
    public User save(User user) {
        return persisnteceMapper.toUser(springUserRepository.save(persisnteceMapper.toUserEntity(user)));
    }

    @Override
    public void deleteById(String id) {
        springUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springUserRepository.findByEmail(email).map(persisnteceMapper::toUser);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return springUserRepository.existsByEmail(email);
    }
}
