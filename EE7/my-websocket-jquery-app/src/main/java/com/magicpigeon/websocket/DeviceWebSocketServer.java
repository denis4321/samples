/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpigeon.websocket;

import com.magicpigeon.model.Device;
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

/**
 * WebSocket Endpoint. It handles the messages
 * @author dmerchang
 */
//@ApplicationScoped
@ServerEndpoint("/actions")
public class DeviceWebSocketServer {
    
   // @Inject
    private DeviceSessionHandler sessionHandler = DeviceSessionHandler.getInstance();

    @OnOpen
    public void open(Session session) {
        sessionHandler.addSession(session);   
    }
    
    @OnClose
    public void close(Session session){
        sessionHandler.removeSession(session);
    }
    
    @OnError
    public void onError(Throwable error) {
        Logger.getLogger(DeviceWebSocketServer.class.getName()).log(Level.SEVERE, null, error);
    }
    
    @OnMessage
    public void handleMessage(String message, Session session) {
        if(1<2){
            Device device = new Device();
            device.setName("name");
            device.setDescription("description");
            device.setType("type");
            device.setStatus("Off");
            sessionHandler.addDevice(device);
            return;
        }

        try (JsonReader reader  = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();
            if ("add".equalsIgnoreCase(jsonMessage.getString("action"))) {
                Device device = new Device();
                device.setName(jsonMessage.getString("name"));
                device.setDescription(jsonMessage.getString("description"));
                device.setType(jsonMessage.getString("type"));
                device.setStatus("Off");
                sessionHandler.addDevice(device);
            }

            if ("remove".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.removeDevice(id);
            }

            if ("toggle".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.toggleDevice(id);
            }
        }
    }
}
