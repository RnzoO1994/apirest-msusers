package com.homework.msusers.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private Long id;

    private String created;

    private String modified;

    private String lastLogin;

    private String token;

    private boolean isActive;
}
