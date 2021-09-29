package com.epam.droneMarket.service.impl;

import com.epam.droneMarket.dao.DaoFactory;
import com.epam.droneMarket.dao.OrderDao;
import com.epam.droneMarket.dao.ProductDao;
import com.epam.droneMarket.entity.Order;
import com.epam.droneMarket.entity.Product;
import com.epam.droneMarket.entity.UserOrder;
import com.epam.droneMarket.exeptions.DaoException;
import com.epam.droneMarket.exeptions.ServiceException;
import com.epam.droneMarket.service.OrderService;
import com.epam.droneMarket.service.ProductService;
import com.epam.droneMarket.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Order> retrieveOrdersByUserWithoutUserOrder(long userId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUserWithoutUserOrder(userId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user id without user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> retrieveOrdersByUser(long userId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUser(userId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user id without user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> retrieveOrdersByUserWhereProductStatusTrue(long userId) throws ServiceException {
        try {
            List<Order> orders = retrieveOrdersByUserWithoutUserOrder(userId);

            ProductService productService = ServiceFactory.getInstance().getProductService();
            Iterator<Order> orderIterator = orders.iterator();
            while (orderIterator.hasNext()) {
                Order nextOrder = orderIterator.next();
                Optional<Product> product = productService.retrieveProductById(nextOrder.getProductId());
                if (product.isPresent()) {
                    if (!product.get().isStatus()) {
                        orderIterator.remove();
                    }
                }
            }

            return orders;
        } catch (ServiceException e) {
            logger.error("Unable to retrieve orders by user id where status is true!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> retrieveOrdersByUserOrder(long userOrderId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> result = null;
            result = orderDao.findByUserOrder(userOrderId);
            return result;
        } catch (DaoException e) {
            logger.error("Unable to retrieve orders by user order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean removeOrderById(long orderId) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            Optional<Order> order = orderDao.findById(orderId);
            if (!order.isPresent()) {
                return false;
            }
            orderDao.removeById(orderId);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to remove order by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewOrder(long userId, long productId, int number) throws ServiceException {
        try {
            OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
            List<Order> existOrders = orderDao.findByUserAndProductWithoutUserOrder(userId, productId);
            if (!(existOrders.size() == 0)) {
                return false;
            }

            Order order = buildOrder(userId, productId, number);
            orderDao.save(order);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add order!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public double calculateTotalCost(List<Order> orders) throws ServiceException {
        double totalCost = 0;
        try {
            ProductDao productDao = DaoFactory.getInstance().getProductDao();
            for (Order order : orders) {
                long productId = order.getProductId();

                Optional<Product> product = productDao.findById(productId);
                if (product.isPresent()) {
                    totalCost += product.get().getPrice() * order.getNumber();
                }
            }
            return totalCost;
        } catch (DaoException e) {
            logger.error("Unable to calculate total cost of orders!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Order> getOrdersFromUserOrders(List<UserOrder> userOrders) throws ServiceException {
        List<Order> orders = new LinkedList<>();

        for (UserOrder userOrder : userOrders) {
            List<Order> order = retrieveOrdersByUserOrder(userOrder.getId());
            if (!order.isEmpty()) {
                orders.addAll(order);
            }
        }

        return orders;
    }

    private Order buildOrder(long userId, long productId, int number) {
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setNumber(number);
        return order;
    }
}
