package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.connection.ConnectionPool;
import com.epam.droneMarket.entity.User;
import com.epam.droneMarket.exeptions.ConnectionException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testLogin_ShouldReturnUser_WhenDataIsCorrect() throws ServiceException {
        Optional<User> actual = userService.login("popovych.ivan@gmail.com", "Popovych123");
        assertTrue(actual.isPresent());
    }

    @Test
    public void testLogin_ShouldReturnNull_WhenDataIsNotCorrect() throws ServiceException {
        Optional<User> actual = userService.login("popovych.victoria", "Popovych321");
        assertFalse(actual.isPresent());
    }

    @Test
    public void testLogin_ShouldReturnNull_WhenDataIsNull() throws ServiceException {
        Optional<User> actual = userService.login(null, null);
        assertFalse(actual.isPresent());
    }
}
