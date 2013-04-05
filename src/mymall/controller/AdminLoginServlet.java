package mymall.controller;

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
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String adminId = "ADMIN";
        final String adminPw = "1234";

        // 로그인 정보
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 로그인 정보가 일치하는 경우 isLogin 세션 생성
        if (id.equals(adminId) && password.equals(adminPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);
            response.sendRedirect("/admin/product/list");
        } else {
            response.sendRedirect("/admin/loginForm");
        }
    }
}
