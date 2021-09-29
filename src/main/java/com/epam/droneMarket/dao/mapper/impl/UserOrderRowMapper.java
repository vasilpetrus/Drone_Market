package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.dao.mapper.RowMapper;
import com.epam.droneMarket.entity.UserOrder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOrderRowMapper implements RowMapper<UserOrder> {

    @Override
    public UserOrder map(ResultSet resultSet) throws SQLException {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(resultSet.getLong(Column.ID));
        userOrder.setAddress(resultSet.getString(Column.USER_ORDER_ADDRESS));
        userOrder.setOrderDate(resultSet.getDate(Column.USER_ORDER_DATE));
        userOrder.setDeliveryDate(resultSet.getDate(Column.USER_ORDER_DELIVERY_DATE));
        userOrder.setStatus(resultSet.getString(Column.USER_ORDER_STATUS));
        return userOrder;
    }
}
