package sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailSender {
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@journaldev.com", "Siarhei Murkou (BOT)"));

            msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessages(String user, String password) throws MessagingException {
        String host = "pop.gmail.com";
        Integer port = 995;

        // Get system properties
        Properties properties = System.getProperties();

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        // Get a Store object that implements the specified protocol.
        Store store = session.getStore("pop3s");

        //Connect to the current host using the specified username and password.
        store.connect(host, port, user, password);

        //Create a Folder object corresponding to the given name.
        Folder folder = store.getFolder("inbox");

        // Open the Folder.
        folder.open(Folder.READ_WRITE);

        // Get the messages from the server
        Message[] messages = folder.getMessages();

        StringBuilder result = new StringBuilder();

        for (Message message: messages) {
            result.append("<div>");
            result.append("<div>").append(InternetAddress.toString(message.getFrom())).append("</div>");
            result.append("<div>").append(message.getSubject()).append("</div>");
            result.append("<div>").append(message.getSentDate()).append("</div>");
            result.append("</div>");
        }

        folder.close(true);
        store.close();

        return result.toString();
    }
}
