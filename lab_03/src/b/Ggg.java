package b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "b.Ggg", urlPatterns = "/ggg")
public class Ggg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST: ggg");
        response.getWriter()
                .append("POST").append("\n")
                .append(request.getParameter("fname")).append("\n")
                .append(request.getParameter("lname"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET: ggg");
        response.getWriter()
                .append("GET").append("\n")
                .append(request.getParameter("fname")).append("\n")
                .append(request.getParameter("lname"));
    }
}
