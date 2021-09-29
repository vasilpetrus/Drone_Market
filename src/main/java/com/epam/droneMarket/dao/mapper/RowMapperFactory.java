package com.epam.droneMarket.dao.mapper;

import com.epam.droneMarket.dao.mapper.impl.CategoryRowMapper;
import com.epam.droneMarket.dao.mapper.impl.OrderRowMapper;
import com.epam.droneMarket.dao.mapper.impl.ProductRowMapper;
import com.epam.droneMarket.dao.mapper.impl.RoleRowMapper;
import com.epam.droneMarket.dao.mapper.impl.UserInformationRowMapper;
import com.epam.droneMarket.dao.mapper.impl.UserOrderRowMapper;
import com.epam.droneMarket.dao.mapper.impl.UserRowMapper;
import com.epam.droneMarket.dao.mapper.impl.BankCardRowMapper;
import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.entity.Order;
import com.epam.droneMarket.entity.Product;
import com.epam.droneMarket.entity.Role;
import com.epam.droneMarket.entity.User;
import com.epam.droneMarket.entity.UserInformation;
import com.epam.droneMarket.entity.UserOrder;
import com.epam.droneMarket.entity.BankCard;

public class RowMapperFactory {
    private final RowMapper<Category> categoryRowMapper = new CategoryRowMapper();
    private final RowMapper<Order> orderRowMapper = new OrderRowMapper();
    private final RowMapper<Product> productRowMapper = new ProductRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<User> userRowMapper = new UserRowMapper();
    private final RowMapper<BankCard> bankCardRowMapper = new BankCardRowMapper();

    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    public RowMapper<Category> getCategoryRowMapper() {
        return categoryRowMapper;
    }

    public RowMapper<Order> getOrderRowMapper() {
        return orderRowMapper;
    }

    public RowMapper<Product> getProductRowMapper() {
        return productRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    public RowMapper<BankCard> getBankCardRowMapper() {
        return bankCardRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
