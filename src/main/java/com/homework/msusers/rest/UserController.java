package com.homework.msusers.rest;

import com.homework.msusers.domain.CreateUserRequest;
import com.homework.msusers.domain.CreateUserResponse;
import com.homework.msusers.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/users")


public class UserController {
    @Autowired
    private UserService createUserUseCase;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(
            @RequestBody CreateUserRequest request
    ) throws Exception {
        log.info("[Start] POST /v1/users");
        try {
            return ResponseEntity.ok(createUserUseCase.create(request));
        } finally {
            log.info("[End] POST /v1/users");
        }
    }
}
