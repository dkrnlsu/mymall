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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 5:59
 * To change this template use File | Settings | File Templates.
 */
public class OrderListServlet extends HttpServlet {
    OrderRepository orderRepository = OrderDbRepository.getInstance();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //1. model에서 데이터 조회
        List<Order> orders = orderRepository.getOrders(session.getAttribute("memberLogin").toString());

        //2. request에 데이터 셋팅
        request.setAttribute("orders",orders);
        request.setAttribute("productMenuEffect","");
        request.setAttribute("orderMenuEffect","class=\"active\"");

        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/order/list.jsp");
        view.forward(request, response);
    }
}
