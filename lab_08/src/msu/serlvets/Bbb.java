package msu.serlvets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Bbb", urlPatterns = "/bbb")
public class Bbb extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration enumeration = request.getHeaderNames();

        String name;
        StringBuilder result = new StringBuilder();
        while ((name = (String)enumeration.nextElement()) != null) {
            String value = request.getHeader(name);
            result.append("<div>").append(name).append(": ").append(value).append("</div>");
            response.setHeader(name, value);
        }

        response.getWriter()
                .println(result);
    }
}
