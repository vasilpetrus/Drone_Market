package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.dao.mapper.RowMapper;
import com.epam.droneMarket.entity.BankCard;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankCardRowMapper implements RowMapper<BankCard> {

    @Override
    public BankCard map(ResultSet resultSet) throws SQLException {
        BankCard bankCard = new BankCard();
        bankCard.setId(resultSet.getLong(Column.ID));
        bankCard.setCardNumber(resultSet.getLong(Column.BANK_CARD_NUMBER));
        bankCard.setCardholderName(resultSet.getString(Column.BANK_CARD_OWNER));
        bankCard.setExpirationMonth(resultSet.getInt(Column.BANK_CARD_EXPIRATION_MONTH));
        bankCard.setExpirationYear(resultSet.getInt(Column.BANK_CARD_EXPIRATION_YEAR));
        bankCard.setBalance(resultSet.getDouble(Column.BANK_CARD_BALANCE));
        bankCard.setCvv(resultSet.getInt(Column.BANK_CARD_CVV));
        return bankCard;
    }
}
