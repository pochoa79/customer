package com.global.customer.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ValidationProperties {

    private String emailRegex;
    private String passwordRegex;


    public ValidationProperties(@Value("${password.regex}") String passwordRegex,
                                @Value("${email.regex}") String emailRegex) {
        this.passwordRegex = passwordRegex;
        this.emailRegex = emailRegex;
    }

}
