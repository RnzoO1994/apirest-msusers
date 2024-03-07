package com.homework.msusers.service;

import com.homework.msusers.domain.CreateUserRequest;
import com.homework.msusers.domain.CreateUserResponse;
import com.homework.msusers.domain.PhoneUserRequest;
import com.homework.msusers.persistence.UserPersistence;
import com.homework.msusers.persistence.entity.Phone;
import com.homework.msusers.persistence.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserPersistence userPersistence;

    @Mock
    private JwtService jwtService;



    @InjectMocks
    @Spy
    private UserService userService;
    @Spy
    private Pattern patternEmail = Pattern.compile(".+@.+\\..+");

    @Spy
    private Pattern patternPassword = Pattern.compile(".{8,}");
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Pattern spyPatternEmail = Mockito.spy(Pattern.compile(".+@.+\\..+"));
        Pattern spyPatternPassword = Mockito.spy(Pattern.compile(".{8,}"));
        Mockito.when(spyPatternEmail.matcher(Mockito.anyString())).thenCallRealMethod();
        Mockito.when(spyPatternPassword.matcher(Mockito.anyString())).thenCallRealMethod();
        Mockito.when(userPersistence.exists(Mockito.any())).thenReturn(false);
    }


    @Test
    void testCreateUser_EmailFormatInvalid() {
        when(userPersistence.exists(any())).thenReturn(false);
        when(jwtService.generateToken(any())).thenReturn("mockedToken");
        // Llamada al método del servicio con email inválido
        assertThrows(Exception.class, () -> userService.create(createMockCreateUserRequestWithEmail("invalidEmail")));
    }

    @Test
    void testCreateUser_EmailAlreadyExists() {
        when(userPersistence.exists(any())).thenReturn(true);
        when(jwtService.generateToken(any())).thenReturn("mockedToken");
        // Llamada al método del servicio con email existente
        assertThrows(Exception.class, () -> userService.create(createMockCreateUserRequest()));
    }private CreateUserRequest createMockCreateUserRequest() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
         createUserRequest.setName("user");
        createUserRequest.setPassword("password");
        createUserRequest.setEmail("user@dominio.com");
        List<PhoneUserRequest> phones = new ArrayList<>();
        createUserRequest.setPhones(phones);
        return  createUserRequest;
    }
    private CreateUserRequest createMockCreateUserRequestWithEmail(String email) {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("user@dominio.com");
        return createUserRequest;
    }
    private User createMockUser() {
        LocalDateTime timestamp = LocalDateTime.now();
        return User.builder()
                .email("user@dominio.cl")
                .password("123456ab")
                .lastLogin(timestamp.toString())
                .token("mockedToken")
                .active(1)
                .created(timestamp.toString())
                .modified(timestamp.toString())
                .build();
    }
}