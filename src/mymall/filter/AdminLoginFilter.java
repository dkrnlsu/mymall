package mymall.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:17
 * To change this template use File | Settings | File Templates.
 */
public class AdminLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
        HttpServletRequest httpRequeset = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // 로그인 체크하여 비로그인시 로그인창으로 이동
        HttpSession session = httpRequeset.getSession();
        if(session.getAttribute("isLogin") == null) {
            httpResponse.sendRedirect("/admin/loginForm");
        } else {
            filterChain.doFilter(httpRequeset, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
