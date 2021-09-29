package com.epam.droneMarket.dao;

import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.exeptions.DaoException;

import java.util.Optional;

public interface CategoryDao extends Dao<Category> {

    /**
     * Method to get category by name from data base
     *
     * @param name name of category
     * @return optional of Category
     * @throws DaoException
     */
    Optional<Category> findByName(String name) throws DaoException;
}
