package mymall.repository;

import mymall.entity.Order;
import mymall.util.OrderUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:38
 * To change this template use File | Settings | File Templates.
 */
public class OrderDbRepository extends DbConnect implements OrderRepository {
    private static OrderDbRepository instance = new OrderDbRepository();

    public static OrderDbRepository getInstance() {
        return instance;
    }

    private OrderDbRepository() {

    }

    @Override
    public List<Order> getOrders() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();
        OrderUtils orderUtils = new OrderUtils();
        try {
            conn = dbConnect();
            String sql = "SELECT a.\"orderId\", a.\"productId\", a.\"userId\", a.quantity, a.payment, a.\"toName\", " +
                    "a.\"toPhone\", a.\"toZipCode\", a.\"toAddr\", a.memo, a.status, a.\"createdDate\", b.\"userName\", c.\"productName\" " +
                    "FROM \"tblOrders\" a INNER JOIN \"tblUsers\" b on a.\"userId\"=b.\"userId\" INNER JOIN \"tblProducts\" c on a.\"productId\"=c.\"productId\" " +
                    "ORDER BY a.\"orderId\" DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                Order order = new Order();
                order.setOrderId(Integer.parseInt(rs.getString("orderId")));
                order.setProductId(Integer.parseInt(rs.getString("productId")));
                order.setUserId(rs.getString("userId"));
                order.setQuantity(Integer.parseInt(rs.getString("quantity")));
                order.setPayment(Integer.parseInt(rs.getString("payment")));
                order.setToName(rs.getString("toName"));
                order.setToPhone(rs.getString("toPhone"));
                order.setToZipCode(rs.getString("toZipCode"));
                order.setToAddr(rs.getString("toAddr"));
                order.setMemo(rs.getString("memo"));
                order.setStatus(orderUtils.getStatusText(rs.getString("status")));
                order.setCreatedDate(rs.getString("createdDate"));
                order.setUserName(rs.getString("userName"));
                order.setProductName(rs.getString("productName"));
                orders.add(order);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return orders;
    }

    @Override
    public List<Order> getOrders(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<Order>();
        OrderUtils orderUtils = new OrderUtils();
        try {
            conn = dbConnect();
            String sql = "SELECT a.\"orderId\", a.\"productId\", a.quantity, a.payment, a.status, a.\"createdDate\", c.\"productName\" " +
                    "FROM \"tblOrders\" a INNER JOIN \"tblUsers\" b on a.\"userId\"=b.\"userId\" and b.\"userId\"=? INNER JOIN \"tblProducts\" c on a.\"productId\"=c.\"productId\" " +
                    "ORDER BY a.\"orderId\" DESC";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                Order order = new Order();
                order.setOrderId(Integer.parseInt(rs.getString("orderId")));
                order.setProductId(Integer.parseInt(rs.getString("productId")));
                order.setQuantity(Integer.parseInt(rs.getString("quantity")));
                order.setPayment(Integer.parseInt(rs.getString("payment")));
                order.setStatus(orderUtils.getStatusText(rs.getString("status")));
                order.setCreatedDate(rs.getString("createdDate"));
                order.setProductName(rs.getString("productName"));
                orders.add(order);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return orders;
    }


    @Override
    public Order getOrder(int orderId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Order order = null;
        try {
            conn = dbConnect();
            String sql = "SELECT a.\"orderId\", a.\"productId\", a.\"userId\", a.quantity, a.payment, a.\"toName\", " +
                    "a.\"toPhone\", a.\"toZipCode\", a.\"toAddr\", a.memo, a.status, a.\"createdDate\", b.\"userName\", c.\"productName\" " +
                    "FROM \"tblOrders\" a INNER JOIN \"tblUsers\" b on a.\"userId\"=b.\"userId\" INNER JOIN \"tblProducts\" c on a.\"productId\"=c.\"productId\" " +
                    "WHERE a.\"orderId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                order = new Order();
                order.setOrderId(Integer.parseInt(rs.getString("orderId")));
                order.setProductId(Integer.parseInt(rs.getString("productId")));
                order.setUserId(rs.getString("userId"));
                order.setQuantity(Integer.parseInt(rs.getString("quantity")));
                order.setPayment(Integer.parseInt(rs.getString("payment")));
                order.setToName(rs.getString("toName"));
                order.setToPhone(rs.getString("toPhone"));
                order.setToZipCode(rs.getString("toZipCode"));
                order.setToAddr(rs.getString("toAddr"));
                order.setMemo(rs.getString("memo"));
                order.setStatus(rs.getString("status"));
                order.setCreatedDate(rs.getString("createdDate"));
                order.setUserName(rs.getString("userName"));
                order.setProductName(rs.getString("productName"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return order;
    }

    @Override
    public Order getOrder(int orderId, String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Order order = null;
        OrderUtils orderUtils = new OrderUtils();
        try {
            conn = dbConnect();
            String sql = "SELECT a.\"orderId\", a.\"productId\", a.\"userId\", a.quantity, a.payment, a.\"toName\", " +
                    "a.\"toPhone\", a.\"toZipCode\", a.\"toAddr\", a.memo, a.status, a.\"createdDate\", b.\"userName\", c.\"productName\" " +
                    "FROM \"tblOrders\" a INNER JOIN \"tblUsers\" b on a.\"userId\"=b.\"userId\" and b.\"userId\"=? INNER JOIN \"tblProducts\" c on a.\"productId\"=c.\"productId\" " +
                    "WHERE a.\"orderId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setInt(2, orderId);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                order = new Order();
                order.setOrderId(Integer.parseInt(rs.getString("orderId")));
                order.setProductId(Integer.parseInt(rs.getString("productId")));
                order.setUserId(rs.getString("userId"));
                order.setQuantity(Integer.parseInt(rs.getString("quantity")));
                order.setPayment(Integer.parseInt(rs.getString("payment")));
                order.setToName(rs.getString("toName"));
                order.setToPhone(rs.getString("toPhone"));
                order.setToZipCode(rs.getString("toZipCode"));
                order.setToAddr(rs.getString("toAddr"));
                order.setMemo(rs.getString("memo"));
                order.setStatus(orderUtils.getStatusText(rs.getString("status")));
                order.setCreatedDate(rs.getString("createdDate"));
                order.setUserName(rs.getString("userName"));
                order.setProductName(rs.getString("productName"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return order;
    }

    @Override
    public void updateOrder(int orderId, String status) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "UPDATE \"tblOrders\" SET status=? WHERE \"orderId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setInt(2, orderId);
            pstmt.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(pstmt, conn);
        }
    }

    @Override
    public void addOrder(Order order, Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO \"tblOrders\" (\"productId\", \"userId\", quantity, payment, \"toName\", \"toPhone\", \"toZipCode\", \"toAddr\", memo, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order.getProductId());
            pstmt.setString(2, order.getUserId());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setInt(4, order.getPayment());
            pstmt.setString(5, order.getToName());
            pstmt.setString(6, order.getToPhone());
            pstmt.setString(7, order.getToZipCode());
            pstmt.setString(8, order.getToAddr());
            pstmt.setString(9, order.getMemo());
            pstmt.setString(10, "E");
            pstmt.executeUpdate();
        } finally {
            dbClose(pstmt);
        }
    }

    @Override
    public void cancelOrder(int orderId, String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "UPDATE \"tblOrders\" SET status='C' WHERE \"orderId\"=? and \"userId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(pstmt, conn);
        }
    }
}
