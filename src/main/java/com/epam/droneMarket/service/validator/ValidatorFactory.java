package com.epam.droneMarket.service.validator;

import com.epam.droneMarket.service.validator.impl.CardNumberValidatorImpl;
import com.epam.droneMarket.service.validator.impl.CvvValidatorImpl;
import com.epam.droneMarket.service.validator.impl.EmailValidatorImpl;
import com.epam.droneMarket.service.validator.impl.MonthValidatorImpl;
import com.epam.droneMarket.service.validator.impl.NameValidatorImpl;
import com.epam.droneMarket.service.validator.impl.PhoneValidatorImpl;
import com.epam.droneMarket.service.validator.impl.PriceValidatorImpl;
import com.epam.droneMarket.service.validator.impl.YearValidatorImpl;
import com.epam.droneMarket.service.validator.impl.IdValidatorImpl;

public class ValidatorFactory {
    private final CardNumberValidatorImpl cardNumberValidator = new CardNumberValidatorImpl();
    private final CvvValidatorImpl cvvValidator = new CvvValidatorImpl();
    private final EmailValidatorImpl emailValidator = new EmailValidatorImpl();
    private final MonthValidatorImpl monthValidator = new MonthValidatorImpl();
    private final NameValidatorImpl nameValidator = new NameValidatorImpl();
    private final PhoneValidatorImpl phoneValidator = new PhoneValidatorImpl();
    private final YearValidatorImpl yearValidator = new YearValidatorImpl();
    private final PriceValidatorImpl priceValidator = new PriceValidatorImpl();
    private final IdValidatorImpl idValidator = new IdValidatorImpl();

    public static ValidatorFactory getInstance() {
        return Holder.INSTANCE;
    }

    public CardNumberValidatorImpl getCardNumberValidator() {
        return cardNumberValidator;
    }

    public CvvValidatorImpl getCvvValidator() {
        return cvvValidator;
    }

    public EmailValidatorImpl getEmailValidator() {
        return emailValidator;
    }

    public MonthValidatorImpl getMonthValidator() {
        return monthValidator;
    }

    public NameValidatorImpl getNameValidator() {
        return nameValidator;
    }

    public PhoneValidatorImpl getPhoneValidator() {
        return phoneValidator;
    }

    public YearValidatorImpl getYearValidator() {
        return yearValidator;
    }

    public PriceValidatorImpl getPriceValidator() {
        return priceValidator;
    }

    public IdValidatorImpl getIdValidator() {
        return idValidator;
    }

    private static class Holder {
        static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
