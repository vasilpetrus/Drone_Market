package com.epam.droneMarket.dao.impl;

import com.epam.droneMarket.dao.AbstractDao;
import com.epam.droneMarket.dao.Table;
import com.epam.droneMarket.dao.UserDao;
import com.epam.droneMarket.dao.mapper.RowMapperFactory;
import com.epam.droneMarket.entity.User;
import com.epam.droneMarket.exeptions.DaoException;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=? and password=SHA1(?)";
    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=?";
    private static final String SAVE_USER_QUERY = "INSERT INTO " + Table.USER + " (email, password, role_id, userInformation_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM " + Table.USER + " WHERE id=?";

    public UserDaoImpl() {
        super(RowMapperFactory.getInstance().getUserRowMapper(), Table.USER);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, password);
    }

    @Override
    public long save(User user) throws DaoException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getEmail(), user.getPassword(),
                user.getRoleId(), user.getUserInformationId());
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }

    @Override
    public void removeById(long id) throws DaoException {
        executeUpdateQuery(DELETE_USER_QUERY, id);
    }
}
