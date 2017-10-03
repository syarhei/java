package c;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

@WebServlet(name = "c.Fff", description = "Servlet using httpclient", urlPatterns = "/fff")
public class Fff extends HttpServlet {
    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        PostMethod pm = new PostMethod("http://localhost:8080" + rq.getContextPath() + "/sss");
        NameValuePair[] parms = {
                new NameValuePair("fname", "Siarhei"),
                new NameValuePair("lname", "Murkou")
        };
        pm.addParameters(parms);
        hc.executeMethod(pm);
        rs.setContentType("text/html");
        rs.getWriter()
                .println(pm.getResponseBodyAsString());
    }
}
