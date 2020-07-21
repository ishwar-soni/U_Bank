package com.upgrad.ubank.utils;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean validatePassword(String password) {
        String passwordValidator = "^[AEIOUaeiou]\\S{4,12}\\d{3}$";
        return Pattern.matches(passwordValidator, password);
    }
}
