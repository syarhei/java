package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SssJson", urlPatterns = "/sss/json")
public class SssJson extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Random random = new Random();
            Integer n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder();

            textResult.append("[");
            for (Integer i = 0; i < n; i++) {
                Integer number = random.nextInt(5) + 5;
                textResult.append(number).append(i < n -1 ? "," : "");
            }
            textResult.append("]");

            Thread.sleep(1000);

            response.setContentType("application/json");
            response.getWriter().println(textResult);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
