/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch03.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author denys.prokopiuk
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/DLQ")
    ,@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    ,@ActivationConfigProperty(propertyName="messageSelector", propertyValue="type='user' AND salary=1")        
})
public class MyMessageListenerWithSelector implements MessageListener {
    
   
    @Override
    public void onMessage(Message message) {
        System.out.println("Filtered message:\t"+message);        
    }
    
}
