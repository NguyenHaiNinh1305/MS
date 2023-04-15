package com.example.commonservice.enumO;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public enum UserType {
    ADMIN("000", "ADMIN"),
    EMPLOYEE("01", "EMPLOYEE"),
    Guest("02", "GUEST");

    public final String code;
    public final String label;

    UserType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static UserType findByCode(String code) {
        if (!StringUtils.hasText(code)) {
            return null;
        }
        return Arrays.stream(UserType.values())
                .filter(t -> t.code.equals(code))
                .findFirst().orElse(null);
    }
}
