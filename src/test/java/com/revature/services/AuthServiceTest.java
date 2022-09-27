package com.revature.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.dtos.LoginRequest;
import com.revature.models.User;

public class AuthServiceTest {
    UserService userService = Mockito.mock(UserService.class);
    AuthService authService = new AuthService(userService);

    @Test
    void testFindByCredentialsSuccessful() {
        User user = new User(1, "r123@gmail.com", "p123", "Rob", "Banks");
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");
        Mockito.when(userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword())).thenReturn(Optional.of(user));

        Assertions.assertEquals(Optional.of(user), authService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @Test
    void testFindByCredentialsUnsuccessful() {
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");
        Mockito.when(userService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword())).thenReturn(Optional.empty());

        Assertions.assertEquals(Optional.empty(), authService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @Test
    void testRegisterExistingUser(){

        User userExists = new User(5,"existingUser@mail.com","password","Yo","yo");
        Mockito.when(userService.getUserByEmail(userExists.getEmail())).thenReturn(Optional.of(userExists));
        Assertions.assertEquals(null, authService.register(userExists));

    }

    @Test
    void testRegisterNewUser(){
        
    }



}
