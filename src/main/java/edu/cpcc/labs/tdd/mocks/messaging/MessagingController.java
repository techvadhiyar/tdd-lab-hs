package edu.cpcc.labs.tdd.mocks.messaging;

public class MessagingController {
	
	private MessagingService smsService;
	private MessagingService emailService;
	
	
	public MessagingController(MessagingService smsService,
			                   MessagingService emailService) {
		this.smsService = smsService;
		this.emailService = emailService;
	}
	
	public Boolean sendSMS(String message) {
		return this.smsService.send(message);
	}

	public Boolean sendEmail(String message) {
		return this.emailService.send(message);
	}
}
