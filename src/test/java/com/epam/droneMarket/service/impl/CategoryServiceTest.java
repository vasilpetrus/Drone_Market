package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.connection.ConnectionPool;
import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.exeptions.ConnectionException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.CategoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryServiceTest {

    CategoryService categoryService = new CategoryServiceImpl();

    @BeforeAll
    static void initializeConnectionPool() throws ConnectionException {
        ConnectionPool.getInstance().initialize();
    }

    @Test
    public void testRetrieveCategoryBtId_ShouldReturnCategory_WhenDataIsCorrect() throws ServiceException {
        Optional<Category> actual = categoryService.retrieveCategoryBtId(2L);
        assertTrue(actual.isPresent());
    }

    @Test
    public void testRetrieveCategoryBtId_ShouldReturnNull_WhenDataIsNotCorrect() throws ServiceException {
        Optional<Category> actual = categoryService.retrieveCategoryBtId(4L);
        assertFalse(actual.isPresent());
    }

    @Test
    public void testRetrieveCategories_ShouldReturnCategories_WhenDataIsNotNull() throws ServiceException {
        List<Category> actual = categoryService.retrieveCategories();

        Category categoryFirst = new Category();
        categoryFirst.setId(1);
        categoryFirst.setCategoryName("Battery");

        Category categorySecond = new Category();
        categorySecond.setId(2);
        categorySecond.setCategoryName("Bags");

        Category categoryThree = new Category();
        categoryThree.setId(3);
        categoryThree.setCategoryName("Filters");

        List<Category> expected = new LinkedList<>();
        expected.add(categorySecond);
        expected.add(categoryThree);
        expected.add(categoryFirst);

        assertEquals(expected, actual);
    }
}
