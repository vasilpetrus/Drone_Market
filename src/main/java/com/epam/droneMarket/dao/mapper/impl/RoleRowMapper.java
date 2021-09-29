package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.dao.mapper.RowMapper;
import com.epam.droneMarket.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getLong(Column.ID));
        role.setName(resultSet.getString(Column.ROLE_NAME));
        return role;
    }
}