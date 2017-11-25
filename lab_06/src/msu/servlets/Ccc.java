package msu.servlets;

import msu.classes.CBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Ccc", urlPatterns = "/ccc")
public class Ccc extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v1 = request.getParameter("value-1");
        String v2 = request.getParameter("value-2");
        String v3 = request.getParameter("value-3");
        String cBeanValue = request.getParameter("cbean");

        ServletContext context = getServletContext();

        CBean cBean = (CBean)context.getAttribute("cbean");

        if (cBean == null || cBeanValue.equals("new")) {
            CBean obj = new CBean(v1 , v2, v3);
            context.setAttribute("cbean", obj);

            response.getWriter()
                    .println("Created new object [CBean]");
        } else {
            cBean.setValue1(checkValue(v1, cBean.getValue1()));
            cBean.setValue2(checkValue(v2, cBean.getValue2()));
            cBean.setValue3(checkValue(v3, cBean.getValue3()));

            context.setAttribute("cbean", cBean);

            response.getWriter()
                    .println("Overwritten old object [CBean]");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        CBean obj = (CBean)context.getAttribute("cbean");

        if (obj != null) {
            response.getWriter()
                    .append("<div>").append(obj.getValue1()).append("</div>")
                    .append("<div>").append(obj.getValue2()).append("</div>")
                    .append("<div>").append(obj.getValue3()).append("</div>");
        } else {
            response.getWriter()
                    .println("<div>Sorry, this object is not  define</div>");
        }
    }

    private String checkValue(String val1, String val2) {
        return !val1.equals("") ? val1 : val2;
    }
}
