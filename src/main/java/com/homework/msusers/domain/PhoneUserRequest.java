package com.homework.msusers.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhoneUserRequest {
    private String number;

    private String cityCode;

    private String countryCode;
}
