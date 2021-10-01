package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.connection.ConnectionPool;
import com.epam.droneMarket.exeptions.ConnectionException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.BankCardService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankCardServiceTest {

    BankCardService bankCardService = new BankCardServiceImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testIsBankCardExist_ShouldReturnTrue_WhenDataIsCorrect() throws ServiceException {
        boolean actual = bankCardService.isBankCardExist(4276880099433504L, 11,
                2022, 291);
        assertTrue(actual);
    }

    @Test
    public void testIsBankCardExist_ShouldReturnFalse_WhenDataIsNotCorrect() throws ServiceException {
        boolean actual = bankCardService.isBankCardExist(4276880099433504L, 11,
                2022, 921);
        assertFalse(actual);
    }
}
