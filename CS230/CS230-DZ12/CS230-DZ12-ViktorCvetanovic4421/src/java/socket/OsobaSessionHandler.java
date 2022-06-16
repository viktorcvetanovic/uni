package socket;

import java.io.IOException;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;
import entity.Osoba;

@ApplicationScoped
public class OsobaSessionHandler {

    private int osobaId = 0;
    private final Set<Session> sessions = new HashSet<Session>();
    private final Set<Osoba> osobe = new HashSet<Osoba>();

    public void addSession(Session session) {
        sessions.add(session);
        for (Osoba osoba : osobe) {
            JsonObject addMessage = createAddMessage(osoba);
            sendToSession(session, addMessage);
        }
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public List getOsobe() {
        return new ArrayList<>(osobe);
    }

    public void addOsoba(Osoba osoba) {
        osoba.setId(osobaId);
        osobe.add(osoba);
        osobaId++;
        JsonObject addMessage = createAddMessage(osoba);
        sendToAllConnectedSessions(addMessage);
    }

    public void removeOsoba(int id) {
        Osoba osoba = getOsobaById(id);
        if (osoba != null) {
            osobe.remove(osoba);
            JsonProvider provider = JsonProvider.provider();
            JsonObject removeMessage = provider.createObjectBuilder()
                    .add("action", "remove")
                    .add("id", id)
                    .build();
            sendToAllConnectedSessions(removeMessage);
        }
    }

    private Osoba getOsobaById(int id) {
        for (Osoba osoba : osobe) {
            if (osoba.getId() == id) {
                return osoba;
            }
        }
        return null;
    }

    private JsonObject createAddMessage(Osoba osoba) {
        JsonProvider provider = JsonProvider.provider();
        JsonObject addMessage = provider.createObjectBuilder()
                .add("action", "add")
                .add("id", osoba.getId())
                .add("ime", osoba.getIme())
                .add("prezime", osoba.getPrezime())
                .add("indeks", osoba.getIndeks())
                .add("nacinStudiranja", osoba.getNacinStudiranja())
                .build();
        return addMessage;
    }

    private void sendToAllConnectedSessions(JsonObject message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) {
            sessions.remove(session);
            Logger.getLogger(OsobaSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
