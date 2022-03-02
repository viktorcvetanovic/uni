package com.viktor.cs230dz01;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/about-servlet")
public class AboutServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Ja sam Viktor. Student sam univerziteta Metropolitan i radim u IST-u!";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Poslao si " + request.getAttribute("msg"));
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        // TODO document why this method is empty
    }
}