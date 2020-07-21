package com.upgrad.ubank.utils;

import java.util.regex.Pattern;

public class AccountNoValidator {
    public static boolean validateAccountNo (int accountNo) {
        String accNo = String.valueOf(accountNo);
        String regex = "^[456]00\\d{3}$";
        return Pattern.matches(regex, accNo);
    }
}
