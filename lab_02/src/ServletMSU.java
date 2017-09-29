import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "ServletMSU", urlPatterns = "/servlet")
public class ServletMSU extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter()
                .append("method: ").append(req.getMethod()).append("<br>")
                .append("First Name is ").append(req.getParameter("FirstName")).append("<br>")
                .append("Last Name is ").append(req.getParameter("LastName")).append("<br>");
        System.out.println("service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
