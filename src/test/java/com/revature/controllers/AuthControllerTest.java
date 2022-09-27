package com.revature.controllers;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.dtos.LoginRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.models.User;
import com.revature.services.AuthService;

public class AuthControllerTest {

    HttpSession session = Mockito.mock(HttpSession.class);
    AuthService authService = Mockito.mock(AuthService.class);
    AuthController authController = new AuthController(authService);

    @Test
    void testLoginSuccessful() {
        User user = new User(1, "r123@gmail.com", "p123", "Rob", "Banks");
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");
        
        Mockito.when(authService.findByCredentials(anyString(), anyString())).thenReturn(Optional.of(user));

        Assertions.assertEquals(ResponseEntity.ok(user), authController.login(loginRequest, session));

        Mockito.verify(session, Mockito.times(1)).setAttribute("user", user);
    }

    @Test
    void testLoginUnsuccessful(){
        LoginRequest loginRequest = new LoginRequest("r123@gmail.com", "p123");

        Mockito.when(authService.findByCredentials(anyString(), anyString())).thenReturn(Optional.empty());

        Assertions.assertEquals(authController.login(loginRequest, session), ResponseEntity.badRequest().build());
    }

    @Test
    void testLogout() {
        Assertions.assertEquals(authController.logout(session), ResponseEntity.ok().build());

        Mockito.verify(session, Mockito.times(1)).removeAttribute("user");
    }

    @Test
    void testRegisterSuccessful() {
       
        RegisterRequest registerRequest = new RegisterRequest("r123@gmail.com", "p123", "Rob", "Banks");

        User user = new User(0, registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getFirstName(), registerRequest.getLastName());

        Mockito.when(authService.register(new User(0, registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getFirstName(), registerRequest.getLastName()))).thenReturn(user);

        Assertions.assertEquals(authController.register(registerRequest), ResponseEntity.status(HttpStatus.CREATED).body(authService.register(user)));
        
    }
}
