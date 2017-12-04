package msu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "F1", urlPatterns = "/ccc")
public class F1 implements Filter {
    public void destroy() {
        System.out.println("F1: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest) req).getMethod().equals("POST") &&
                req.getParameter("value-1").equals(req.getParameter("value-2"))  ) {

            System.out.println("F1: Error");
            resp.getWriter()
                    .println("F1: Error: (value-1 == value-2)");
        }
        else {
            System.out.println("F1: doFilter");
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("F1: init");
    }

}
