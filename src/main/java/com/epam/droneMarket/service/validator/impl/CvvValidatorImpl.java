package com.epam.droneMarket.service.validator.impl;

import com.epam.droneMarket.service.validator.AbstractValidator;

public class CvvValidatorImpl extends AbstractValidator {
    private static final String CVV_REGEX = "^[0-9]{3}$";

    @Override
    protected String getRegex() {
        return CVV_REGEX;
    }
}
