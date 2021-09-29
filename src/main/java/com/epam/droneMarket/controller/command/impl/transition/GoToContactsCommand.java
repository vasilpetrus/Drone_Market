package com.epam.droneMarket.controller.command.impl.transition;

import com.epam.droneMarket.controller.command.Command;
import com.epam.droneMarket.controller.command.CommandResult;
import com.epam.droneMarket.controller.command.CommandResultType;
import com.epam.droneMarket.controller.context.RequestContext;
import com.epam.droneMarket.controller.context.RequestContextHelper;
import com.epam.droneMarket.entity.Category;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.CategoryService;
import com.epam.droneMarket.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToContactsCommand implements Command {
    private static final String PAGE = "WEB-INF/view/contacts.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CATEGORIES = "categories";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            CategoryService categoryService = ServiceFactory.getInstance().getCategoryService();
            List<Category> categories = categoryService.retrieveCategories();
            requestContext.addRequestAttribute(CATEGORIES, categories);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
