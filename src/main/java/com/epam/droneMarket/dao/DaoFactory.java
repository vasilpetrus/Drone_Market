package com.epam.droneMarket.dao;

import com.epam.droneMarket.dao.impl.CategoryDaoImpl;
import com.epam.droneMarket.dao.impl.RoleDaoImpl;
import com.epam.droneMarket.dao.impl.UserDaoImpl;
import com.epam.droneMarket.dao.impl.OrderDaoImpl;
import com.epam.droneMarket.dao.impl.ProductDaoImpl;
import com.epam.droneMarket.dao.impl.UserInformationDaoImpl;
import com.epam.droneMarket.dao.impl.UserOrderDaoImpl;
import com.epam.droneMarket.dao.impl.BankCardDaoImpl;

public class DaoFactory {
    private final UserDao userDao = new UserDaoImpl();
    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();
    private final ProductDao productDao = new ProductDaoImpl();
    private final OrderDao orderDao = new OrderDaoImpl();
    private final UserOrderDao userOrderDao = new UserOrderDaoImpl();
    private final BankCardDao bankCardDao = new BankCardDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CategoryDaoImpl getCategoryDao() {
        return categoryDao;
    }

    public RoleDaoImpl getRoleDao() {
        return roleDao;
    }

    public UserInformationDaoImpl getUserInformationDao() {
        return userInformationDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public UserOrderDao getUserOrderDao() {
        return userOrderDao;
    }

    public BankCardDao getBankCardDao() {
        return bankCardDao;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
