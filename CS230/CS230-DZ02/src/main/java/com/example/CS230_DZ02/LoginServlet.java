package com.example.CS230_DZ02;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Vase ime: "+request.getParameter("username"));
        out.println("Vasa sifra: "+request.getParameter("password"));
        out.println("Link do novog servleta: <a href='/end-servlet'>Klikni me</a>");
        out.println("</body></html>");
    }


}