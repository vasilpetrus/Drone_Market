package com.epam.droneMarket.service.validator.impl;

import com.epam.droneMarket.service.validator.AbstractValidator;

public class PhoneValidatorImpl extends AbstractValidator {
    private static final String PHONE_REGEX = "^[0-9]{10,15}$";

    @Override
    protected String getRegex() {
        return PHONE_REGEX;
    }
}
