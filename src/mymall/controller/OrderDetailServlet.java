package mymall.controller;

import mymall.entity.Order;
import mymall.entity.User;
import mymall.repository.OrderDbRepository;
import mymall.repository.OrderRepository;

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
public class OrderDetailServlet extends HttpServlet {
    OrderRepository orderRepository = OrderDbRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("memberLogin").toString();
        //1. model에서 데이터 조회
        Order order = orderRepository.getOrder(Integer.parseInt(request.getParameter("orderId")), userId);

        //2. request에 데이터 셋팅
        if (order == null) {
            response.sendRedirect("/order/list");
        } else {
            request.setAttribute("orderId",order.getOrderId());
            request.setAttribute("productId",order.getProductId());
            request.setAttribute("userId",order.getUserId());
            request.setAttribute("quantity",order.getQuantity());
            request.setAttribute("payment",order.getPayment());
            request.setAttribute("toName",order.getToName());
            request.setAttribute("toPhone",order.getToPhone());
            request.setAttribute("toZipCode",order.getToZipCode());
            request.setAttribute("toAddr",order.getToAddr());
            request.setAttribute("memo",order.getMemo());
            request.setAttribute("statusText",order.getStatus());
            request.setAttribute("createdDate",order.getCreatedDate());
            request.setAttribute("userName",order.getUserName());
            request.setAttribute("productName",order.getProductName());

            request.setAttribute("productMenuEffect","");
            request.setAttribute("orderMenuEffect","class=\"active\"");
        }
        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/order/detail.jsp");
        view.forward(request, response);
    }
}
