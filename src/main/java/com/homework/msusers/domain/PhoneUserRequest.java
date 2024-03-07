package com.homework.msusers.domain;

import lombok.Data;

@Data
public class PhoneUserRequest {
    private String number;

    private String cityCode;

    private String countryCode;
}
