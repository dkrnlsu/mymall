package mymall.repository;
import mymall.entity.Product;

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
public interface ProductRepository {

    List<Product> getProducts();

    List<Product> getUserProducts();

    void addProduct(Product product);

    Product getProduct(int productId);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    void minusQuantity(int productId, int quantity, Connection conn) throws SQLException;

    void plusQuantity(int productId, int quantity, Connection conn) throws SQLException;
}
