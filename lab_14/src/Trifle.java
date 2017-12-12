import java.applet.Applet;
import java.awt.*;

public class Trifle extends Applet {
    private StringBuilder result = new StringBuilder();

    @Override
    public void init() {
        result.append("-init-");
    }

    public void start() {
        result.append("-start-");
    }

    public void stop() {
        result.append("-stop-");
    }

    public void destroy() {
        result.append("-destroy-");
    }

    public void paint(Graphics graphics) {
        result.append("-paint-");
        String param = getParameter("param");
        graphics.drawString(result.toString(), 200, 200);
    }
}
