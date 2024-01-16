package com.hero.SchoolHub.util.validators.validators;

import com.hero.SchoolHub.util.exceptions.BodyGuardException;

import java.util.List;

import static java.lang.String.join;

public interface Validator <P, R>{
    R validate(P input);
}
