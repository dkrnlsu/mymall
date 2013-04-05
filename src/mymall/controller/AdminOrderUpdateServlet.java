package mymall.controller;

import mymall.repository.OrderDbRepository;
import mymall.repository.OrderRepository;

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
public class AdminOrderUpdateServlet extends HttpServlet {
    OrderRepository orderRepository = OrderDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //데이터 저장
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");

        orderRepository.updateOrder(orderId, status);

        //list로 이동
        response.sendRedirect("/admin/order/list");
    }
}
