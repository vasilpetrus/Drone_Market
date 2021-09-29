package com.epam.droneMarket.dao.impl;

import com.epam.droneMarket.dao.AbstractDao;
import com.epam.droneMarket.dao.CategoryDao;
import com.epam.droneMarket.dao.Table;
import com.epam.droneMarket.dao.mapper.RowMapperFactory;
import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.exeptions.DaoException;

import java.util.Optional;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {
    private static final String SAVE_CATEGORY_QUERY = "INSERT INTO " + Table.CATEGORY + " (category) VALUES (?)";
    private static final String FIND_CATEGORY_BY_NAME_QUERY = "SELECT * FROM " + Table.CATEGORY + " WHERE category=?";

    public CategoryDaoImpl() {
        super(RowMapperFactory.getInstance().getCategoryRowMapper(), Table.CATEGORY);
    }

    @Override
    public long save(Category category) throws DaoException {
        return executeInsertQuery(SAVE_CATEGORY_QUERY, category.getCategoryName());
    }

    @Override
    public Optional<Category> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_CATEGORY_BY_NAME_QUERY, name);
    }
}
