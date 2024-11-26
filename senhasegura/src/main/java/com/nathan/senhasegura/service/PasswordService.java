package com.nathan.senhasegura.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePassword(String pass) {
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);
        validateUppercase(pass, failures);
        validateLowercase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialCharacteres(pass, failures);

        return failures;
    }

    private void validateLength(String pass, List<String> failures){
        if(pass != null && pass.length() < 8) {
            failures.add("A senha deve possuir pelo menos 8 caracteres.");
        }
    }

    private void validateUppercase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add("A senha deve possuir pelo menos uma letra maiúscula");
        }
    }

    private void validateLowercase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[a-z].*", pass)) {
            failures.add("A senha deve possuir pelo menos uma letra minuscula");
        }
    }

    private void validateNumber(String pass, List<String> failures) {
        if(!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("A senha deve possuir pelo menos uma letra minuscula");
        }
    }

    private void validateSpecialCharacteres(String pass, List<String> failures) {
        if(!Pattern.matches(".*[\\W].*", pass)) {
            failures.add("A senha deve possuir pelo menos um caractere especial (!@#$%)");
        }
    }

}
