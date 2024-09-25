package com.global.customer.service.impl;

import com.global.customer.service.ValidateService;
import com.global.customer.util.ValidationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Slf4j
@Service
@AllArgsConstructor
public class ValidateImpl  implements ValidateService {

    private final ValidationProperties validationProperties;


    public boolean isValidEmail(String email) {
       // Pattern pattern = Pattern.compile(validationProperties.getEmailRegex());
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$");
        return pattern.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(validationProperties.getPasswordRegex());
        return pattern.matcher(password).matches();
    }
}
