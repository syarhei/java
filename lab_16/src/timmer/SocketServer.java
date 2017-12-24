package timmer;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/socket")
public class SocketServer extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig){
        try {
            RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote();
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
            while (true) {
                remoteEndpointBasic.sendText(format.format(new Date()));
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}