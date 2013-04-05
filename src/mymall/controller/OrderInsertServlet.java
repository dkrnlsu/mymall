package mymall.controller;

import mymall.entity.Order;
import mymall.service.OrderService;

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
public class OrderInsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("memberLogin").toString();

        //데이터 저장
        Order order = new Order();
        order.setProductId(Integer.parseInt(request.getParameter("productId")));
        order.setUserId(userId);
        order.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        order.setPayment(Integer.parseInt(request.getParameter("payment")));

        order.setToName(request.getParameter("toName"));
        order.setToPhone(request.getParameter("toPhone"));
        order.setToZipCode(request.getParameter("toZipCode"));
        order.setToAddr(request.getParameter("toAddr"));
        order.setMemo(request.getParameter("memo"));

        // 주문처리
        OrderService orderService = new OrderService();
        boolean orderFinish = orderService.order(order);

        //2. request에 데이터 셋팅
        request.setAttribute("productMenuEffect","class=\"active\"");
        request.setAttribute("orderMenuEffect","");

        //정상 주문
        if (orderFinish) {
            //jsp찾아서 이동
            RequestDispatcher view = request.getRequestDispatcher("/order/finish.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/order/fail.jsp");
            view.forward(request, response);
        }
    }
}
