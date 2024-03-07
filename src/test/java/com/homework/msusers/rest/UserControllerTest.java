package com.homework.msusers.rest;

import com.homework.msusers.domain.CreateUserRequest;
import com.homework.msusers.domain.CreateUserResponse;
import com.homework.msusers.domain.PhoneUserRequest;
import com.homework.msusers.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void createUser() throws  Exception {
        when(userService.create(any())).thenReturn(createMockUserResponse());
        // Llamada al método del controlador
        ResponseEntity<CreateUserResponse> responseEntity = userController.createUser(createMockCreateUserRequest());
        verify(userService, times(1)).create(any());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    private CreateUserRequest createMockCreateUserRequest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("user");
        createUserRequest.setPassword("password");
        createUserRequest.setEmail("user@dominio.com");
        List<PhoneUserRequest> phones = new ArrayList<>();
        createUserRequest.setPhones(phones);
        return  createUserRequest;
    }

    private CreateUserResponse createMockUserResponse() {
        return new CreateUserResponse(1L, "2024-03-07", "2024-03-07", "2024-03-07", "token123", true);
    }
}