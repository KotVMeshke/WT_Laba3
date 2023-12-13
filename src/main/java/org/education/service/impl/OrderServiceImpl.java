package org.education.service.impl;


import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;
import org.education.DAO.OrderDao;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.CartItem;
import org.education.beans.OrdersEnt;
import org.education.service.OrderService;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public static float CalculateOrderPrice(List<CartItem> cart){
        float result = 0;
        for (CartItem cartItem : cart) {
            result += cartItem.getAmount()* Float.parseFloat(cartItem.getProduct().getProPrice())*(100-cartItem.getProduct().getProDiscount())/100;
        }
        return result;
    }
    @Override
    public void createOrder(String address, List<CartItem> cart) throws ServiceException {
        try{
            if (address != null && cart != null) {
                OrdersEnt order = OrdersEnt.builder().ordAddress(address).ordPrice(CalculateOrderPrice(cart)).ordStatus(0).build();
                orderDao.CreateOrder(order);
            }
        }catch (DatabaseQueryException ex){
            throw new ServiceException(ex.getMessage());
        }

    }
}
