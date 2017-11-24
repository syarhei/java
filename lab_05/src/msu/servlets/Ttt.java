package msu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Ttt", urlPatterns = "/ttt")
public class Ttt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter()
                .append("<div>").append(request.getParameter("name-tag")).append("</div>")
                .append("<div>").append(request.getParameter("surname-tag")).append("</div>")
                .append("<div>").append(request.getParameter("sex-tag")).append("</div>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
