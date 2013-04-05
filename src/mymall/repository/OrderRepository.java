package mymall.repository;
import mymall.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:35
 * To change this template use File | Settings | File Templates.
 */
public interface OrderRepository {

    List<Order> getOrders();

    List<Order> getOrders(String userId);

    Order getOrder(int orderId);

    Order getOrder(int orderId, String userId);

    void updateOrder(int orderId, String status);

    void addOrder(Order order, Connection conn) throws SQLException;

    void cancelOrder(int orderId, String userId);
}
