package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.dao.mapper.RowMapper;
import com.epam.droneMarket.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category map(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong(Column.ID));
        category.setCategoryName(resultSet.getString(Column.CATEGORY_NAME));
        return category;
    }
}
