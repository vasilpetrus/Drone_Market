package com.epam.droneMarket.controller.command.impl;

import com.epam.droneMarket.controller.command.Command;
import com.epam.droneMarket.controller.command.CommandResult;
import com.epam.droneMarket.controller.command.CommandResultType;
import com.epam.droneMarket.controller.context.RequestContext;
import com.epam.droneMarket.controller.context.RequestContextHelper;
import com.epam.droneMarket.entity.Product;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.ProductService;
import com.epam.droneMarket.service.ServiceFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ConfirmProductChangeCommand implements Command {
    private static final String PAGE = "command=catalog";
    private static final String CATEGORY_PARAMETER = "&categoryId=";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String PRODUCT_NAME = "product-name";
    private static final String PHOTO = "photo";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";
    private static final String DESCRIPTION = "description";
    private static final String AVAILABILITY = "availability";
    private static final String PRODUCT_ID = "productId";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        Optional<String> productName = Optional.ofNullable(requestContext.getRequestParameter(PRODUCT_NAME));
        Optional<String> photo = Optional.ofNullable(requestContext.getRequestParameter(PHOTO));
        Optional<String> price = Optional.ofNullable(requestContext.getRequestParameter(PRICE));
        Optional<String> category = Optional.ofNullable(requestContext.getRequestParameter(CATEGORY));
        Optional<String> description = Optional.ofNullable(requestContext.getRequestParameter(DESCRIPTION));
        Optional<String> availability = Optional.ofNullable(requestContext.getRequestParameter(AVAILABILITY));
        Optional<String> productId = Optional.ofNullable(requestContext.getRequestParameter(PRODUCT_ID));

        try {
            ProductService productService = ServiceFactory.getInstance().getProductService();
            long categoryId = 0;

            if (productName.isPresent() && photo.isPresent() && price.isPresent() && category.isPresent() &&
                    description.isPresent()) {
                boolean status = false;
                if (availability.isPresent()) {
                    status = true;
                }

                productService.updateProductInformation(productId.get(), productName.get(),
                        photo.get(), price.get(), category.get(), status, description.get());
            }
            Optional<Product> product = productService.retrieveProductById(Long.parseLong(productId.get()));
            if (product.isPresent()) {
                categoryId = product.get().getCategoryId();
                helper.updateRequest(requestContext);
                return new CommandResult(PAGE + CATEGORY_PARAMETER + categoryId, CommandResultType.REDIRECT);
            }
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }
    }
}
