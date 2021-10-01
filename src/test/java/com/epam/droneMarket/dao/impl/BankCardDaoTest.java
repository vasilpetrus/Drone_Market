package com.epam.droneMarket.dao.impl;

import com.epam.droneMarket.dao.BankCardDao;
import com.epam.droneMarket.dao.connection.ConnectionPool;
import com.epam.droneMarket.entity.BankCard;
import com.epam.droneMarket.exeptions.ConnectionException;
import com.epam.droneMarket.exeptions.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankCardDaoTest {

    BankCardDao bankCardDao = new BankCardDaoImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testFindByCardNumber_ShouldReturnBankCard_WhenDataIsCorrect() throws DaoException {
        Optional<BankCard> actual = bankCardDao.findByCardNumber(4276880099433504L);
        BankCard expected = new BankCard();
        expected.setId(2);
        expected.setCardNumber(4276880099433504L);
        expected.setExpirationYear(2022);
        expected.setExpirationMonth(10);
        expected.setCardholderName("IVAN POPOVYCH");
        expected.setCvv(271);
        expected.setBalance(15100.00);
        assertEquals(expected, actual.get());
    }
}
