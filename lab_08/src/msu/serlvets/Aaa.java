package msu.serlvets;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "Aaa", urlPatterns = "/aaa")
public class Aaa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host = request.getServerName();
        int port = request.getServerPort();
        String url = String.format("http://%s:%d%s", host, port, "/bbb");

        String p1 = request.getParameter("param1");
        String p2 = request.getParameter("param2");
        String p3 = request.getParameter("param3");

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);

        Map map = request.getParameterMap();
        for (Object key: map.keySet()) {
            String keyName = (String)key;
            String[] value = (String[])map.get(keyName);
            method.addRequestHeader(keyName, value[0]);
        }



        client.executeMethod(method);

        String body = method.getResponseBodyAsString();

        Header[] headers = method.getResponseHeaders();

        StringBuilder result = new StringBuilder();
        for (Header header: headers) {
            result.append("<div>").append(header.getName()).append(": ").append(header.getValue()).append("</div>");
        }

        response.getWriter()
                .append("<div class='title-name'>Headers of Request</div>")
                .append(body)
                .append("<div class='title-name'>Headers of Response</div>")
                .append(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}