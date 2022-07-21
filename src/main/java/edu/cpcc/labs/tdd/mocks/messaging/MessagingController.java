package edu.cpcc.labs.tdd.mocks.messaging;

import java.util.Hashtable;

public class MessagingController {
	
	private Hashtable<String, MessagingService> serviceCatalog = new Hashtable<>();
	
	// NOTE: modified the controller to take the concrete classes...
	public MessagingController(SMSMessagingService smsService,
			                   EmailMessagingService emailService) {
		this.serviceCatalog.put("SMS", smsService);
		this.serviceCatalog.put("EMAIL", emailService);
	}
	
	public Boolean sendSMS(String message) {
		return this.serviceCatalog.get("SMS").send(message);
	}

	public Boolean sendEmail(String message) {
		return this.serviceCatalog.get("EMAIL").send(message);
	}
}
