package servlets;

import sender.MailSender;

import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "Mailer", urlPatterns = "/api/email/message")
public class Mailer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eMailAddressTo = request.getParameter("eMailAddressTo");
        String eMailMessage = request.getParameter("eMailMessage");
        String eMailMessageSubject = request.getParameter("eMailMessageSubject");
        final String eMailPasswordFrom = request.getParameter("eMailPasswordFrom");
        final String eMailAddressFrom = request.getParameter("eMailAddressFrom");

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(eMailAddressFrom, eMailPasswordFrom);
            }
        };
        Session session = Session.getInstance(props, auth);

        MailSender.sendEmail(session, eMailAddressTo, eMailMessageSubject, eMailMessage);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String result = MailSender.getMessages(username, password);

            resp.getWriter()
                    .println(result);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
