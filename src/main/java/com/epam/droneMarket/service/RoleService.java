package com.epam.droneMarket.service;

import com.epam.droneMarket.entity.Role;
import com.epam.droneMarket.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    /**
     * Method to retrieve role by ID
     *
     * @param roleId ID of role to retrieve
     * @return optional of Role
     * @throws ServiceException
     */
    Optional<Role> retrieveRoleById(long roleId) throws ServiceException;
}
