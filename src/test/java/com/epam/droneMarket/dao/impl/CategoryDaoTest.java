package com.epam.droneMarket.dao.impl;

import com.epam.droneMarket.dao.CategoryDao;
import com.epam.droneMarket.dao.connection.ConnectionPool;
import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.exeptions.ConnectionException;
import com.epam.droneMarket.exeptions.DaoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryDaoTest {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testFindByName_ShouldReturnCategory_WhenDataIsCorrect() throws DaoException {
        Optional<Category> actual = categoryDao.findByName("Battery");
        Category expected = new Category();
        expected.setId(1);
        expected.setCategoryName("Battery");
        assertEquals(expected, actual.get());
    }

    @Test
    public void testFindById_ShouldReturnCategory_WhenDataIsCorrect() throws DaoException {
        Optional<Category> actual = categoryDao.findById(1);
        Category expected = new Category();
        expected.setId(1);
        expected.setCategoryName("Battery");
        assertEquals(expected, actual.get());
    }
}
