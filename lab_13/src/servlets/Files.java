package servlets;

import filefilters.Finder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "Files", urlPatterns = "/files")
public class Files extends HttpServlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String filename = rq.getParameter("file");
        String dir   = getServletContext().getInitParameter("doc-dir");

        if (filename == null) {
            Finder files = new Finder(dir, "docx");

            StringBuilder result = new StringBuilder();
            result.append("<div>");
            for (String file : files.list) {
                result
                        .append("<div>")
                        .append("<a href='/files?file=").append(file).append("' >").append(file).append("</a>")
                        .append("</div>");
            }
            result.append("</div>");

            rs.getWriter().println(result);
        }
        else {
            File doc = new File(dir.concat("/").concat(filename));
            rs.setContentType("application/application");
            rs.addHeader("Content-Disposition", "attachment; filename="+
                    doc.getName());
            rs.setContentLength((int) doc.length());

            FileInputStream in = new FileInputStream(doc);
            BufferedInputStream buf = new BufferedInputStream(in);
            ServletOutputStream out = rs.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1) {
                out.write(readBytes);
            }
        }
    }
}
