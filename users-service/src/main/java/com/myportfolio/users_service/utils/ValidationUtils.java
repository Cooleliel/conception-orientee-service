package com.myportfolio.users_service.utils;

import com.myportfolio.users_service.utils.exception.BadAttributeValueTypeException;
import com.myportfolio.users_service.utils.exception.BadRequestEntryException;

public class ValidationUtils {
    public static void validateEmail(String email) {
        if (!(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))) {
            throw new BadAttributeValueTypeException("email", "exemple@gmail.com");
        }
    }

    public static void validatePassword(String password) {
        if (password.length() <= 4) {
            throw new BadRequestEntryException("Password requis au moins 5 caractères");
        }
    }
}

