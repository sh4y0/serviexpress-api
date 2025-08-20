package com.servi.serviexpress_api.user.application.service;

import com.servi.serviexpress_api.user.application.ports.input.UserServicePortIn;
import com.servi.serviexpress_api.user.application.ports.output.UserPersistencePortOut;
import com.servi.serviexpress_api.user.domain.exception.UserProfileAlreadyCompletedException;
import com.servi.serviexpress_api.user.domain.exception.UserAlreadyExistsException;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;
import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategy;
import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategyFactory;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategy;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategyFactory;
import com.servi.serviexpress_api.user.domain.exception.UserNotFoundException;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.strategy.validate.ProfileValidatorStrategy;
import com.servi.serviexpress_api.user.domain.strategy.validate.ProfileValidatorStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserServicePortIn {
    private final UserPersistencePortOut persistencePortOut;
    private final ProfileValidatorStrategyFactory profileValidatorStrategyFactory;
    private final ProfileUpdateStrategyFactory updateStrategyFactory;
    private final ProfileCreationStrategyFactory profileCreationStrategyFactory;

    @Override
    public User findById(String id) {
        return persistencePortOut.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return persistencePortOut.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        if (persistencePortOut.findByEmail(user.getEmail()).isPresent()) throw new UserAlreadyExistsException();

        ProfileCreationStrategy strategy = profileCreationStrategyFactory.findStrategy(user.getRole());
        strategy.createProfile(user);

        return persistencePortOut.save(user);
    }

    @Override
    @Transactional
    public User completeUserProfile(String id, UserProfileData userProfileData) {
        Objects.requireNonNull(id, "User ID cannot be null");
        Objects.requireNonNull(userProfileData, "UserProfileData cannot be null");

        User userToUpdate = persistencePortOut.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if (userToUpdate.isCompleteProfile()) {
            throw new UserProfileAlreadyCompletedException();
        }

        ProfileValidatorStrategy validatorStrategy = Optional.ofNullable(
                profileValidatorStrategyFactory.findStrategy(userToUpdate.getRole())
        ).orElseThrow(() -> new IllegalStateException("No validator strategy for role: " + userToUpdate.getRole()));
        validatorStrategy.validate(userProfileData);

        ProfileUpdateStrategy strategy = Optional.ofNullable(
                updateStrategyFactory.findStrategy(userToUpdate.getRole())
        ).orElseThrow(() -> new IllegalStateException("No update strategy for role: " + userToUpdate.getRole()));
        strategy.updateProfileDetails(userToUpdate, userProfileData);

        userToUpdate.setName(userProfileData.name());
        userToUpdate.setLastName(userProfileData.lastName());
        userToUpdate.setPhone(userProfileData.phone());
        userToUpdate.setProfileImageUrl(userProfileData.profileImageUrl());
        userToUpdate.setLatitude(userProfileData.latitude());
        userToUpdate.setLongitude(userProfileData.longitude());
        userToUpdate.setCompleteProfile(true);

        return persistencePortOut.save(userToUpdate);
    }

    @Override
    public void deleteById(String id) {
        if (persistencePortOut.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        persistencePortOut.deleteById(id);
    }
}
