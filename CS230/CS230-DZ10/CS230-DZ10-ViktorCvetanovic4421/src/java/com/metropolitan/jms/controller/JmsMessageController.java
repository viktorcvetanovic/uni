/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.jms.controller;

import com.metropolitan.jms.model.JmsMessageModel;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author BiG
 */
@Named
@RequestScoped
public class JmsMessageController {

    @Inject
    private JmsMessageModel jmsMessageModel;
    @Resource(mappedName = "jms/mojRed")
    private Queue mojRed;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public String sendMessage() {
        if(jmsMessageModel.getMessageText().equals("Japanska akita")){
            sendJMSMessage(jmsMessageModel.getMessageText());
            return "tacanOdgovor";
        }
        sendJMSMessage(jmsMessageModel.getMessageText());
        return "netacanOdgovor";
    }

    private void sendJMSMessage(String messageData) {
        context.createProducer().send(mojRed, messageData);
    }

}
