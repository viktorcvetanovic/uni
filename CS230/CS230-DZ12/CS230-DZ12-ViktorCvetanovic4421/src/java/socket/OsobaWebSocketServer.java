package socket;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import entity.Osoba;

@ApplicationScoped
@ServerEndpoint("/actions")
public class OsobaWebSocketServer {

    @Inject
    private OsobaSessionHandler sessionHandler;

    @OnOpen
    public void open(Session session) {
        sessionHandler.addSession(session);
    }

    @OnClose
    public void close(Session session) {
        sessionHandler.removeSession(session);
    }

    @OnError
    public void onError(Throwable error) {
        Logger.getLogger(OsobaWebSocketServer.class.getName()).log(Level.SEVERE, null, error);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();

            if ("add".equals(jsonMessage.getString("action"))) {
                Osoba osoba = new Osoba();
                osoba.setIme(jsonMessage.getString("ime"));
                osoba.setPrezime(jsonMessage.getString("prezime"));
                osoba.setIndeks(jsonMessage.getInt("indeks"));
                osoba.setNacinStudiranja(jsonMessage.getString("nacinStudiranja"));
                sessionHandler.addOsoba(osoba);
            }

            if ("remove".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.removeOsoba(id);
            }

        }
    }
}
