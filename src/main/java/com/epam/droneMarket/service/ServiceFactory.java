package com.epam.droneMarket.service;

import com.epam.droneMarket.service.impl.CategoryServiceImpl;
import com.epam.droneMarket.service.impl.OrderServiceImpl;
import com.epam.droneMarket.service.impl.UserServiceImpl;
import com.epam.droneMarket.service.impl.ProductServiceImpl;
import com.epam.droneMarket.service.impl.RoleServiceImpl;
import com.epam.droneMarket.service.impl.UserInformationServiceImpl;
import com.epam.droneMarket.service.impl.UserOrderServiceImpl;
import com.epam.droneMarket.service.impl.BankCardServiceImpl;

public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();
    private final UserInformationService userInformationService = new UserInformationServiceImpl();
    private final UserOrderService userOrderService = new UserOrderServiceImpl();
    private final BankCardService bankCardService = new BankCardServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public BankCardService getBankCardService() {
        return bankCardService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserInformationService getUserInformationService() {
        return userInformationService;
    }

    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
