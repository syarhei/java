package msu.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class L2 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public L2() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeAdded:AtributeName= "
                +sbe.getName());
        System.out.println("L2:attributeAdded:AtributeValue "
                +sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeRemoved:AtributeName= "
                +sbe.getName());
        System.out.println("L2:attributeRemoved:AtributeValue "
                +sbe.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeReplaced:AtributeName="
                +sbe.getName());
        System.out.println("L2:attributeReplaced:AtributeOldValue "
                +sbe.getValue());
    }
}
