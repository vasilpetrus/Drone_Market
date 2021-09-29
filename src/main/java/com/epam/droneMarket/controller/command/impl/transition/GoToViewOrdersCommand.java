package com.epam.droneMarket.controller.command.impl.transition;

import com.epam.droneMarket.controller.command.Command;
import com.epam.droneMarket.controller.command.CommandResult;
import com.epam.droneMarket.controller.command.CommandResultType;
import com.epam.droneMarket.controller.context.RequestContext;
import com.epam.droneMarket.controller.context.RequestContextHelper;
import com.epam.droneMarket.entity.*;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToViewOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CATEGORIES = "categories";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String PRODUCTS = "products";
    private static final String ORDERS = "orders";
    private static final String USER_INFORMATION = "userInformation";
    private static final String EXPECTED = "очікується";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            CategoryService categoryService = ServiceFactory.getInstance().getCategoryService();
            List<Category> categories = categoryService.retrieveCategories();
            requestContext.addRequestAttribute(CATEGORIES, categories);

            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders = userOrderService.retrieveUserOrderByStatus(EXPECTED);
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);

            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            List<Order> orders = orderService.getOrdersFromUserOrders(userOrders);
            requestContext.addRequestAttribute(ORDERS, orders);

            ProductService productService = ServiceFactory.getInstance().getProductService();
            List<Product> products = productService.getProductsFromOrders(orders);
            requestContext.addRequestAttribute(PRODUCTS, products);

            UserService userService = ServiceFactory.getInstance().getUserService();
            List<User> users = userService.getUsersFromOrders(orders);
            requestContext.addRequestAttribute(USERS, users);

            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();
            List<UserInformation> userInformation = userInformationService.getUserInformationFromUsers(users);
            requestContext.addRequestAttribute(USER_INFORMATION, userInformation);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
