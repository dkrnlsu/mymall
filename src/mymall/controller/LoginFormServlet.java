package mymall.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
public class LoginFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿠키중 ID 저장 값이 있다면 넣어주기
        Cookie[] cookies = request.getCookies();
        String idSave = "";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("idsave")) {
                idSave = cookie.getValue();
            }
        }
        request.setAttribute("idSave", idSave);

        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/member/loginForm.jsp");
        view.forward(request, response);
    }
}
