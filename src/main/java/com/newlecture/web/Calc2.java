package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext application = request.getServletContext();
        HttpSession session= request.getSession();
        Cookie[] cookies = request.getCookies();


        String v_ = request.getParameter("v");
        String op = request.getParameter("operator");

        int v = 0;
        if (!v_.isEmpty()) v = Integer.parseInt(v_);

        if (op.equals("=")) {
//            int x = (Integer) application.getAttribute("value");
//            int x = (Integer) session.getAttribute("value");
            int x = 0;
            for(Cookie c : cookies) {
                if (c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }

            int y = v;

//            String operator = (String)application.getAttribute("op");
//            String operator = (String)session.getAttribute("op");
            String operator = "";
            for(Cookie c : cookies) {
                if (c.getName().equals("op")) {
                    operator = c.getValue();
                    break;
                }
            }

            int result = 0;

            if (operator.equals("+")) {
                result = x+y;
            } else {
                result = x-y;
            }

            response.getWriter().println("답은 : " + result);
        } else {
            application.setAttribute("value", v);
            application.setAttribute("op", op);

//            session.setAttribute("value", v);
//            session.setAttribute("op", op);

            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);
            valueCookie.setPath("/calc2");
            valueCookie.setMaxAge(60);
            opCookie.setPath("/calc2");
            response.addCookie(valueCookie);
            response.addCookie(opCookie);
        }
    }
}