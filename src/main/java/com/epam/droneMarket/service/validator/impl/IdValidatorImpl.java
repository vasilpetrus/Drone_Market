package com.epam.droneMarket.service.validator.impl;

import com.epam.droneMarket.service.validator.AbstractValidator;

public class IdValidatorImpl extends AbstractValidator {
    private static final String ID_REGEX = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";

    @Override
    protected String getRegex() {
        return ID_REGEX;
    }
}
