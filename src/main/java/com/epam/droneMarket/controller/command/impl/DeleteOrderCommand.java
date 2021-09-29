package com.epam.droneMarket.controller.command.impl;

import com.epam.droneMarket.controller.command.Command;
import com.epam.droneMarket.controller.command.CommandResult;
import com.epam.droneMarket.controller.command.CommandResultType;
import com.epam.droneMarket.controller.context.RequestContext;
import com.epam.droneMarket.controller.context.RequestContextHelper;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.OrderService;
import com.epam.droneMarket.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;

public class DeleteOrderCommand implements Command {
    private static final String PAGE = "command=basket";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String ORDER_ID = "orderId";


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            long orderId = Long.parseLong(requestContext.getRequestParameter(ORDER_ID));
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            orderService.removeOrderById(orderId);
        } catch (ServiceException | NumberFormatException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
