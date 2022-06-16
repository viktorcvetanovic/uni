/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author BiG
 */
@ServerEndpoint("/wsendpoint")
public class WSEndpoint {

    @OnMessage
    public String onMessage(String message) {
        String retVal;
        if (message.equals("get_defaults")) {
            retVal = new StringBuilder("{").
                    append("\"ime\":\"Auto\",").
                    append("\"prezime\":\"Generated\"").
                    append("}").toString();
        } else {
            retVal = "";
        }
        return retVal;
    }

}
