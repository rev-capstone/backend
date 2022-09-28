package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.dtos.LoginRequest;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

public class UserServiceTest {
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    UserService userService = new UserService(userRepository);

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

    @Test
    void testSaveUserSuccessful() {
        //arrange
        User expected = new User(1, "j@gmail.com", "password", "firstName", "lastName");
        Mockito.when(userRepository.save(expected)).thenReturn(expected);

        //act
        User actual = userService.save(expected);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetUserByEmailSuccess(){
        String email = "j@gmail.com";
        User user = new User(1, "j@gmail.com", "password", "firstName", "lastName");
        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        Assertions.assertEquals(Optional.of(user), userService.getUserByEmail(email));
    }
}
