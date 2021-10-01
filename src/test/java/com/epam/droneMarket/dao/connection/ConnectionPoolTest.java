package com.epam.droneMarket.dao.connection;

import com.epam.droneMarket.exeptions.ConnectionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConnectionPoolTest {

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    void testGetInstance_ShouldReturnTheSameClass_Always() {
        ConnectionPool poolFirst = ConnectionPool.getInstance();
        ConnectionPool poolSecond = ConnectionPool.getInstance();

        assertEquals(poolFirst, poolSecond);
    }

    private void assertEquals(ConnectionPool poolFirst, ConnectionPool poolSecond) {
    }

    @Test
    void testGetConnection_ShouldReturnTrue_WhenConnectionValidTenSeconds() throws SQLException {
        assertTrue(ConnectionPool.getInstance().getConnection().isValid(10));
    }
}
