package com.revature.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.dtos.LoginRequest;
import com.revature.models.User;

public class UserServiceTest {
    UserService userService = Mockito.mock(UserService.class);

    @Test
    void testFindByCredentialsSuccessful() {
        User user = new User(1, "r123@gmail.com", "p123", "Rob", "Banks");
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");
        Mockito.when(userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword())).thenReturn(Optional.of(user));

        Assertions.assertEquals(Optional.of(user), userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @Test
    void testFindByCredentialsUnsuccessful() {
        
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");
        Mockito.when(userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword())).thenReturn(Optional.empty());

        Assertions.assertEquals(Optional.empty(), userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword()));
    }
}
