package org.education.DAO;

import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.CartItem;
import org.education.beans.OrdersEnt;

import java.util.List;

/**
 * Interface handling order-related database operations.
 */
public interface OrderDao {

    void CreateOrder(OrdersEnt ordersEnt) throws DatabaseQueryException;
}
