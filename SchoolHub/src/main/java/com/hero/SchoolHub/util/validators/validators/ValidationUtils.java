package com.hero.SchoolHub.util.validators.validators;

import com.hero.SchoolHub.util.exceptions.BodyGuardException;

import java.util.List;

import static java.lang.String.join;

public class ValidationUtils {

    public static void validate(List<String> violations) {
        if (!violations.isEmpty()) {
            throw new BodyGuardException(join(",", violations));
        }
    }
}
