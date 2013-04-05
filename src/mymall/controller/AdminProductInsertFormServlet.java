package mymall.controller;

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
public class AdminProductInsertFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productMenuEffect","class=\"active\"");
        request.setAttribute("orderMenuEffect","");

        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/admin/product/insertForm.jsp");
        view.forward(request, response);
    }
}
