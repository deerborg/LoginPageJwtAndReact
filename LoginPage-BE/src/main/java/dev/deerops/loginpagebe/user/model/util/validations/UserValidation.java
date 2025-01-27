package dev.deerops.loginpagebe.user.model.util.validations;

import dev.deerops.loginpagebe.user.model.util.exceptions.UserGeneralValidationsException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidation {

    public void validateUserField(String username, String email, String password) {

        Map<String, String> fieldList = new HashMap<>();

        fieldList.put("Username", username);
        fieldList.put("Email", email);
        fieldList.put("Password", password);

        if (username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            for (Map.Entry<String, String> entry : fieldList.entrySet()) {
                if (entry.getValue().trim().isEmpty()) {
                    throw new UserGeneralValidationsException(entry.getKey() + " is empty");
                }
            }
        }

        emailFormatIsValid(email);

        passwordLengthIsValid(password);
    }


    private void emailFormatIsValid(String email) {
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new UserGeneralValidationsException("Bad email format");
        }

    }

    private void passwordLengthIsValid(String password) {
        if (password.length() < 8) {
            throw new UserGeneralValidationsException("Password length not smaller then 8");
        }
    }

}
