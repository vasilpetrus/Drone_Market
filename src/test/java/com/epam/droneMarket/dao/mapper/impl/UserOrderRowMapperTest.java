package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.entity.UserOrder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserOrderRowMapperTest {

    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";
    private static final Date EXPECTED_DATE = new Date(120);

    @Test
    void testMap_ShouldReturnUserOrder_WhenDataIsCorrect() throws SQLException {
        Date sqlDate = new Date(EXPECTED_DATE.getTime());

        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.USER_ORDER_ADDRESS)).thenReturn(EXPECTED_STRING);
        Mockito.when(rsMock.getDate(Column.USER_ORDER_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getDate(Column.USER_ORDER_DELIVERY_DATE)).thenReturn(sqlDate);
        Mockito.when(rsMock.getString(Column.USER_ORDER_STATUS)).thenReturn(EXPECTED_STRING);

        UserOrderRowMapper userOrderRowMapper = new UserOrderRowMapper();
        UserOrder actual = userOrderRowMapper.map(rsMock);

        UserOrder expected = new UserOrder();
        expected.setId(EXPECTED_LONG);
        expected.setAddress(EXPECTED_STRING);
        expected.setOrderDate(sqlDate);
        expected.setDeliveryDate(sqlDate);
        expected.setStatus(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}
