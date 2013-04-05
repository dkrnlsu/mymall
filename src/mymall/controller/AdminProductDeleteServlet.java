package mymall.controller;

import mymall.repository.ProductDbRepository;
import mymall.repository.ProductRepository;

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
public class AdminProductDeleteServlet extends HttpServlet {
    ProductRepository productRepository = ProductDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        productRepository.deleteProduct(productId);

        //list로 이동
        response.sendRedirect("/admin/product/list");
    }
}
