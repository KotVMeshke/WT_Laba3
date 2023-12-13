package org.education.DAO.impl;

import org.education.DAO.OrderDao;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.CartItem;
import org.education.beans.OrdersEnt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * Implementation of OrderDao that handles orders using an SQL database.
 */
@Component
public class SQLOrderDAO implements OrderDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SQLOrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Calculates the total price of an order based on the provided cart.
     * @param cart The list of items in the cart.
     * @return The calculated total order price.
     */
    public static float CalculateOrderPrice(List<CartItem> cart){
        float result = 0;
        for (CartItem cartItem : cart) {
            result += cartItem.getAmount()* Float.parseFloat(cartItem.getProduct().getProPrice())*(100-cartItem.getProduct().getProDiscount())/100;
        }
        return result;
    }
    @Override
    public void CreateOrder(OrdersEnt ordersEnt) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(ordersEnt));

    }
}
