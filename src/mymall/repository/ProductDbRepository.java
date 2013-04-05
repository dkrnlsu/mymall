package mymall.repository;

import mymall.entity.Product;
import mymall.util.ProductUtils;

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
public class ProductDbRepository extends DbConnect implements ProductRepository {
    private static ProductDbRepository instance = new ProductDbRepository();

    public static ProductDbRepository getInstance() {
        return instance;
    }

    private ProductDbRepository() {

    }

    @Override
    public List<Product> getProducts() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();
        ProductUtils productUtils = new ProductUtils();
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblProducts\" ORDER BY \"productId\" DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                Product product = new Product();
                product.setProductId(Integer.parseInt(rs.getString("productId")));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
                product.setPrice(Integer.parseInt(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setStatus(productUtils.getStatusText(rs.getString("status")));
                product.setCreatedDate(rs.getString("createdDate"));
                products.add(product);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return products;
    }

    @Override
    public List<Product> getUserProducts() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();
        ProductUtils productUtils = new ProductUtils();
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblProducts\" where status='1' and quantity > 0 ORDER BY \"productId\" DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                Product product = new Product();
                product.setProductId(Integer.parseInt(rs.getString("productId")));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
                product.setPrice(Integer.parseInt(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setStatus(productUtils.getStatusText(rs.getString("status")));
                product.setCreatedDate(rs.getString("createdDate"));
                products.add(product);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "INSERT INTO \"tblProducts\" (\"productName\", \"productImage\", price, quantity, status) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getProductImage());
            pstmt.setInt(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getStatus());
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
    public Product getProduct(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblProducts\" WHERE \"productId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                product = new Product();
                product.setProductId(Integer.parseInt(rs.getString("productId")));
                product.setProductName(rs.getString("productName"));
                product.setProductImage(rs.getString("productImage"));
                product.setPrice(Integer.parseInt(rs.getString("price")));
                product.setQuantity(Integer.parseInt(rs.getString("quantity")));
                product.setStatus(rs.getString("status"));
                product.setCreatedDate(rs.getString("createdDate"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "UPDATE \"tblProducts\" SET \"productName\"=?, \"productImage\"=?, price=?, quantity=?, status=? WHERE \"productId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getProductImage());
            pstmt.setInt(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getStatus());
            pstmt.setInt(6, product.getProductId());
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
    public void deleteProduct(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "DELETE FROM \"tblProducts\" WHERE \"productId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
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
    public void minusQuantity(int productId, int quantity, Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE \"tblProducts\" SET \"quantity\"=(\"quantity\" - ?) WHERE \"productId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, productId);
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } finally {
            dbClose(pstmt);
        }
    }

    @Override
    public void plusQuantity(int productId, int quantity, Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE \"tblProducts\" SET \"quantity\"=(\"quantity\" + ?) WHERE \"productId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, productId);
            System.out.println(pstmt);
            pstmt.executeUpdate();
        } finally {
            dbClose(pstmt);
        }
    }
}
