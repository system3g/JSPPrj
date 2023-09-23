package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class Nana extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String temp = request.getParameter("cnt");
        int cnt = 0;
        if(temp != null && !temp.equals("")) cnt = Integer.parseInt(temp);
        PrintWriter out = response.getWriter();
        for (int i = 0; i < cnt; i++) {
            out.println((i + 1) + ":안녕  Servlet!!<br>");
        }
    }
}