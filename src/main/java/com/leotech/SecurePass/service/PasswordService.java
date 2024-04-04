package com.leotech.SecurePass.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validate(String pass ){
        List<String> failures = new ArrayList<>();

        validateLenght(pass, failures);
        validateUpperCase(pass, failures);
        validateLowerCase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialCharacter(pass, failures);

        return failures;
    }

    private void validateLenght(String pass, List<String> failures) {
        if (pass.isBlank() || pass.length() < 8) {
            failures.add("Password length must be between 8 and 16 characters");
        }
    }

    private void validateUpperCase(String pass, List<String> failures) {

        if (!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add("Password must be UpperCase characters");
        }
    }

    private void validateLowerCase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[a-z].*", pass)) {
            failures.add("Password must be lower case characters");
        }
    }

    private void validateNumber(String pass, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("Password must be Number characters");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", pass)){
            failures.add("Password must contain special characters");
        }
    }
}
