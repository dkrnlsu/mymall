package mymall.controller;

import mymall.entity.Order;
import mymall.repository.OrderDbRepository;
import mymall.repository.OrderRepository;
import mymall.service.OrderCancelService;

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
public class OrderCancelServlet extends HttpServlet {
    OrderRepository orderRepository = OrderDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //데이터 저장
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        HttpSession session = request.getSession();
        String userId = session.getAttribute("memberLogin").toString();

        // 취소처리
        OrderCancelService orderCancelService = new OrderCancelService();
        boolean orderCancelFinish = orderCancelService.orderCancel(orderId, productId, userId, quantity, payment);

        //2. request에 데이터 셋팅
        request.setAttribute("productMenuEffect","class=\"active\"");
        request.setAttribute("orderMenuEffect","");

        //list로 이동
        response.sendRedirect("/order/list");
    }
}