package com.epam.droneMarket.dao.impl;

import com.epam.droneMarket.dao.AbstractDao;
import com.epam.droneMarket.dao.Table;
import com.epam.droneMarket.dao.mapper.RowMapperFactory;
import com.epam.droneMarket.entity.UserInformation;
import com.epam.droneMarket.exeptions.DaoException;

public class UserInformationDaoImpl extends AbstractDao<UserInformation> {
    private static final String SAVE_USER_INFORMATION_QUERY = "INSERT INTO " + Table.USER_INFORMATION +
            " (name, surname, patronymic, phone) VALUES (?, ?, ?, ?)";

    public UserInformationDaoImpl() {
        super(RowMapperFactory.getInstance().getUserInformationRowMapper(), Table.USER_INFORMATION);
    }

    @Override
    public long save(UserInformation userInformation) throws DaoException {
        return executeInsertQuery(SAVE_USER_INFORMATION_QUERY, userInformation.getName(),
                userInformation.getSurname(), userInformation.getPatronymic(), userInformation.getPhone());
    }
}
