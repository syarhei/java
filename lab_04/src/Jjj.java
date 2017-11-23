import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

@WebServlet(name = "Jjj", urlPatterns = "/jjj")
public class Jjj extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int c;  // char value for each symbol of answer from .jsp

        String page = hour < 6 ? "night.jsp" : hour < 12 ? "morning.jsp" : hour < 18 ? "afternoon.jsp" : "evening.jsp";

        URL url = new URL("http://localhost:8080/pages/".concat(page));
        URLConnection connection = url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream input = connection.getInputStream();
        StringBuilder result = new StringBuilder();

        while((c = input.read()) != -1) {
            result.append((char) c);
        }
        input.close();

        Document document = Jsoup.parse(result.toString());
        String body = document.body().html();

        response.getWriter()
                .append(body);
    }
}
