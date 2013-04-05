package mymall.controller;

import mymall.entity.Product;
import mymall.entity.User;
import mymall.repository.ProductDbRepository;
import mymall.repository.ProductRepository;
import mymall.repository.UserDbRepository;
import mymall.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:28
 * To change this template use File | Settings | File Templates.
 */
public class OrderFormServlet extends HttpServlet {
    ProductRepository productRepository = ProductDbRepository.getInstance();
    UserRepository userRepository = UserDbRepository.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. model에서 데이터 조회
        Product product = productRepository.getProduct(Integer.parseInt((request.getParameter("productId"))));
        HttpSession session = request.getSession();
        String userId = session.getAttribute("memberLogin").toString();
        User user = userRepository.getUser(userId);

        //2. request에 데이터 셋팅
        if (product == null || user == null ) {
            response.sendRedirect("/product/list");
        } else {
            request.setAttribute("productMenuEffect","class=\"active\"");
            request.setAttribute("orderMenuEffect","");

            request.setAttribute("productId",product.getProductId());
            request.setAttribute("productName",product.getProductName());
            request.setAttribute("productImage",product.getProductImage());
            request.setAttribute("price",product.getPrice());

            request.setAttribute("userName",user.getUserName());
            request.setAttribute("cyberMoney",user.getCyberMoney());
            request.setAttribute("phone",user.getPhone());
            request.setAttribute("zipCode",user.getZipCode());
            request.setAttribute("addr",user.getAddr());
        }
        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/order/orderForm.jsp");
        view.forward(request, response);
    }
}
