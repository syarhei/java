package msu.servlets;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Jjj", urlPatterns = "/jjj")
public class Jjj extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlNumber = request.getParameter("url-number");
        ServletContext context = getServletContext();
        String api = context.getInitParameter(String.format("URL%s", urlNumber));

        if (api != null) {
            String host = request.getServerName();
            int port = request.getServerPort();
            String url = String.format("http://%s:%d%s", host, port, api);

            HttpClient client = new HttpClient();
            GetMethod method = new GetMethod(url);
            client.executeMethod(method);

            String body = method.getResponseBodyAsString();

            response.getWriter()
                    .println(body);
        } else {
            response.getWriter()
                    .println("<div>URL parameter is not found</div>");
        }

    }
}
