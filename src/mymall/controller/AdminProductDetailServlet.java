package mymall.controller;

import mymall.entity.Product;
import mymall.repository.ProductDbRepository;
import mymall.repository.ProductRepository;
import mymall.util.ProductUtils;

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
public class AdminProductDetailServlet extends HttpServlet {
    ProductRepository productRepository = ProductDbRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. model에서 데이터 조회
        Product product = productRepository.getProduct(Integer.parseInt((request.getParameter("productId"))));

        //2. request에 데이터 셋팅
        if (product == null) {
            response.sendRedirect("/admin/product/list");
        } else {
            ProductUtils productUtils = new ProductUtils();
            request.setAttribute("productId",product.getProductId());
            request.setAttribute("productName",product.getProductName());
            request.setAttribute("productImage",product.getProductImage());
            request.setAttribute("price",product.getPrice());
            request.setAttribute("quantity",product.getQuantity());
            request.setAttribute("status",productUtils.getStatusText(product.getStatus()));
            request.setAttribute("createdDate",product.getCreatedDate());

            request.setAttribute("productMenuEffect","class=\"active\"");
            request.setAttribute("orderMenuEffect","");
        }
        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/admin/product/detail.jsp");
        view.forward(request, response);
    }
}
