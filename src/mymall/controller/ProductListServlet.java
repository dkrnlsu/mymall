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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 5:59
 * To change this template use File | Settings | File Templates.
 */
public class ProductListServlet extends HttpServlet {
    ProductRepository productRepository = ProductDbRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. model에서 데이터 조회
        List<Product> products = productRepository.getUserProducts();


        //2. request에 데이터 셋팅
        request.setAttribute("products",products);
        request.setAttribute("productMenuEffect","class=\"active\"");
        request.setAttribute("orderMenuEffect","");

        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/product/list.jsp");
        view.forward(request, response);
    }

}
