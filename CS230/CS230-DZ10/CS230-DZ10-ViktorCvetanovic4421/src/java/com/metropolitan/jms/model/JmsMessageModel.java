/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.jms.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author BiG
 */
@Named
@RequestScoped
public class JmsMessageModel {
    
    private String messageText;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
}