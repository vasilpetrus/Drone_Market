package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.DaoFactory;
import com.epam.droneMarket.dao.RoleDao;
import com.epam.droneMarket.entity.Role;
import com.epam.droneMarket.exeptions.DaoException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<Role> retrieveRoleById(long roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve role by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
