package mymall.controller;

import mymall.entity.Product;
import mymall.repository.ProductDbRepository;
import mymall.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:28
 * To change this template use File | Settings | File Templates.
 */
public class AdminProductInsertServlet extends HttpServlet {
    ProductRepository productRepository = ProductDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //데이터 저장
        Product product = new Product();
        product.setProductName(request.getParameter("productName"));
        product.setProductImage(request.getParameter("productImage"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setStatus(request.getParameter("status"));
        productRepository.addProduct(product);

        //list로 이동
        response.sendRedirect("/admin/product/list");
    }
}
