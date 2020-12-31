package com.miles.sm.controller;

import com.miles.sm.entity.Staff;
import com.miles.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sun.security.util.Password;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Miles
 * @date 2020/12/30 10:53
 */
@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = selfService.login(account, password);
        if (staff == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session =request.getSession();
            session.setAttribute("USER",staff);
            System.out.println(staff);
            response.sendRedirect("main.do");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session =request.getSession();
        session.setAttribute("USER",null);
        response.sendRedirect("toLogin.do");
    }

    public void info(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("USER");
        System.out.println((Staff)user);
        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }
    public void changePassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("USER");
        Staff staff = (Staff) user;
        Integer id = staff.getId();
        String realPassword = staff.getPassword();
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        if (realPassword.equals(password)){
            selfService.changePassword(id,password1);
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
//            response.sendRedirect("toLogin.do");
        }else {
            response.sendRedirect("toChangePassword.do");
        }
    }

    public void toChangePassword(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("../change_password.jsp").forward(request,response);
    }

}
