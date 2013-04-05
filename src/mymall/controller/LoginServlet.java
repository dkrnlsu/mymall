package mymall.controller;

import mymall.entity.User;
import mymall.repository.UserDbRepository;
import mymall.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:28
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
    UserRepository userRepository = UserDbRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자 로그인 정부
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String idsave = request.getParameter("idsave");

        if (id.equals("") || password.equals("")) {
            response.sendRedirect("/member/loginForm");
        } else {
            //1. model에서 데이터 조회
            User user = userRepository.getUser(id, password);
            System.out.println(user);
            if (user == null) {
                response.sendRedirect("/member/loginForm");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("memberLogin", id);

                // ID 저장 체크가 안된 경우
                if (idsave == null) {
                    // 기존 저장된 쿠키값이 있다면 제거
                    Cookie[] cookies = request.getCookies();
                    for (Cookie cookie: cookies) {
                        if (cookie.getName().equals("idsave")) {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                    }
                    // ID 저장 체크된 경우 - 해당 쿠키 저장
                } else {
                    Cookie cookie = new Cookie("idsave", id);
                    // 30일 유지
                    cookie.setMaxAge(86400 * 30);
                    response.addCookie(cookie);
                }
                response.sendRedirect("/product/list");
            }
        }

    }
}
