package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.DaoFactory;
import com.epam.droneMarket.dao.impl.UserInformationDaoImpl;
import com.epam.droneMarket.entity.User;
import com.epam.droneMarket.entity.UserInformation;
import com.epam.droneMarket.exeptions.DaoException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.UserInformationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserInformationServiceImpl implements UserInformationService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<UserInformation> retrieveUserInformationById(long userInformationId) throws ServiceException {
        try {
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            Optional<UserInformation> result;
            result = userInformationDao.findById(userInformationId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve user information by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException {
        List<UserInformation> userInformation = new LinkedList<>();
        try {
            for (User user : users) {
                Optional<UserInformation> information = retrieveUserInformationById(user.getUserInformationId());
                if (information.isPresent()) {
                    if (!userInformation.contains(information.get())) {
                        userInformation.add(information.get());
                    }
                }
            }
        } catch (ServiceException e) {
            logger.error("Unable to get user information from users!");
            throw new ServiceException(e.getMessage(), e);
        }

        return userInformation;
    }
}
