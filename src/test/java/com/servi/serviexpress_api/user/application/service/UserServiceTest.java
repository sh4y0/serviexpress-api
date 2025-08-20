package com.servi.serviexpress_api.user.application.service;

import com.servi.serviexpress_api.user.application.ports.output.UserPersistencePortOut;
import com.servi.serviexpress_api.user.domain.exception.UserAlreadyExistsException;
import com.servi.serviexpress_api.user.domain.exception.UserNotFoundException;
import com.servi.serviexpress_api.user.domain.model.Role;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.domain.model.UserProfileData;
import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategy;
import com.servi.serviexpress_api.user.domain.strategy.create.ProfileCreationStrategyFactory;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategy;
import com.servi.serviexpress_api.user.domain.strategy.update.ProfileUpdateStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserPersistencePortOut persistencePortOut;

    @Mock
    private ProfileUpdateStrategyFactory updateStrategyFactory;

    @Mock
    private ProfileCreationStrategyFactory profileCreationStrategyFactory;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_whenUserExists_shouldReturnUser() {
        // Given
        String setId = "1";
        User expectedUser = new User();
        expectedUser.setId(setId);
        when(persistencePortOut.findById(setId)).thenReturn(Optional.of(expectedUser));

        // When
        User actualUser = userService.findById(setId);

        // Then
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void findById_whenUserDoesNotExist_shouldThrowUserNotFoundException() {
        // Given
        String setId = "1";
        when(persistencePortOut.findById(setId)).thenReturn(Optional.empty());

        // Then
        assertThrows(UserNotFoundException.class, () -> {
            // When
            userService.findById(setId);
        });
    }

    @Test
    void save_whenUserDoesNotExist_shouldSaveUser() {
        // Given
        User userToSave = new User();
        userToSave.setEmail("test@example.com");
        userToSave.setRole(Role.valueOf("CUSTOMER"));

        when(persistencePortOut.findByEmail(userToSave.getEmail())).thenReturn(Optional.empty());

        ProfileCreationStrategy strategy = mock(ProfileCreationStrategy.class);
        when(profileCreationStrategyFactory.findStrategy(userToSave.getRole())).thenReturn(strategy);

        when(persistencePortOut.save(userToSave)).thenReturn(userToSave);

        // When
        User savedUser = userService.save(userToSave);

        // Then
        assertNotNull(savedUser);
        assertEquals(userToSave.getEmail(), savedUser.getEmail());
        verify(strategy).createProfile(userToSave);
        verify(persistencePortOut).save(userToSave);
    }

    @Test
    void save_whenUserAlreadyExists_shouldThrowUserAlreadyExistsException() {
        // Given
        User existingUser = new User();
        existingUser.setEmail("test@example.com");

        when(persistencePortOut.findByEmail(existingUser.getEmail())).thenReturn(Optional.of(existingUser));

        // Then
        assertThrows(UserAlreadyExistsException.class, () -> {
            // When
            userService.save(existingUser);
        });

        verify(persistencePortOut, never()).save(any(User.class));
    }

    @Test
    void completeUserProfile_whenUserExists_shouldUpdateUserProfile() {
        // Given
        String setId = "1";
        User userToUpdate = new User();
        userToUpdate.setId(setId);
        userToUpdate.setRole(Role.valueOf("CUSTOMER"));

        UserProfileData userProfileData = new UserProfileData("John", "Doe", "image.url", "1234567890", 1.0, 1.0, null, null);

        when(persistencePortOut.findById(setId)).thenReturn(Optional.of(userToUpdate));

        ProfileUpdateStrategy strategy = mock(ProfileUpdateStrategy.class);
        when(updateStrategyFactory.findStrategy(userToUpdate.getRole())).thenReturn(strategy);

        when(persistencePortOut.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        User updatedUser = userService.completeUserProfile(setId, userProfileData);

        // Then
        assertNotNull(updatedUser);
        assertTrue(updatedUser.isCompleteProfile());
        assertEquals(userProfileData.name(), updatedUser.getName());
        assertEquals(userProfileData.lastName(), updatedUser.getLastName());
        assertEquals(userProfileData.phone(), updatedUser.getPhone());
        assertEquals(userProfileData.profileImageUrl(), updatedUser.getProfileImageUrl());
        assertEquals(userProfileData.latitude(), updatedUser.getLatitude());
        assertEquals(userProfileData.longitude(), updatedUser.getLongitude());

        verify(strategy).updateProfileDetails(userToUpdate, userProfileData);
        verify(persistencePortOut).save(userToUpdate);
    }

    @Test
    void completeUserProfile_whenUserDoesNotExist_shouldThrowUserNotFoundException() {
        // Given
        String setId = "1";
        UserProfileData userProfileData = new UserProfileData("John", "Doe", "image.url", "1234567890", 1.0, 1.0, null, null);

        when(persistencePortOut.findById(setId)).thenReturn(Optional.empty());

        // Then
        assertThrows(UserNotFoundException.class, () -> {
            // When
            userService.completeUserProfile(setId, userProfileData);
        });

        verify(persistencePortOut, never()).save(any(User.class));
    }

    @Test
    void deleteById_whenUserExists_shouldDeleteUser() {
        // Given
        String setId = "1";
        User userToDelete = new User();
        userToDelete.setId(setId);
        when(persistencePortOut.findById(setId)).thenReturn(Optional.of(userToDelete));

        // When
        userService.deleteById(setId);

        // Then
        verify(persistencePortOut).deleteById(setId);
    }

    @Test
    void deleteById_whenUserDoesNotExist_shouldThrowUserNotFoundException() {
        // Given
        String setId = "1";
        when(persistencePortOut.findById(setId)).thenReturn(Optional.empty());

        // Then
        assertThrows(UserNotFoundException.class, () -> {
            // When
            userService.deleteById(setId);
        });

        verify(persistencePortOut, never()).deleteById(anyString());
    }
}
