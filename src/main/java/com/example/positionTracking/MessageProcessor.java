package com.example.positionTracking;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
	
	@Autowired
	private DataRepository data;
	
	/*
	 * This method responds to message being received on the queue. 
	 * The message will be in text form and Spring will automatically convert into a standard javva map like hashmap
	 */
	@JmsListener(destination="VehiclePositionQueue")
	public void processPositionMessageFromQueue(Map<String, String> incomingMessage) {
		//send incoming message into the data
		data.updatePosition(incomingMessage);
		//System.out.println("\nReceived messsage: " + incomingMessage);
	}

}
