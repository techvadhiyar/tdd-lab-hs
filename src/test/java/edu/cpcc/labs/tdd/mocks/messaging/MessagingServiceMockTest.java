package edu.cpcc.labs.tdd.mocks.messaging;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

// NOTE: the @ExtendWith annotation is used to integrate JUnit5 with  Mockito....
@ExtendWith(MockitoExtension.class)
class MessagingServiceMockTest {
	
	@Mock (name="mockSMSService")
	MessagingService  mockSMSService;
	
	@Mock (name="mockEmailService")
	MessagingService  mockEmailService;
		
	@InjectMocks
	MessagingController messagingController;
		
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMockSMSService() {
		
		// make sure the mock is initialized
		assertNotNull(mockSMSService);
		assertNotNull(messagingController);		

		// setup data
		String message = "This is a test SMS.";
		
		// define your condition for the Mock...mimicking...
		when(mockSMSService.send(message)).thenReturn(true);
		
		// execute test...
		
		// this line is not necessary...since we are injecting the mocks into the controller...
		// which will also create the controller...
		// MessagingController messagingController = new MessagingController(mockSMSService);
		
		// mock call...
		Boolean returnStatus = messagingController.sendSMS(message);
		
		// Validate test...
		assertTrue(returnStatus);
	}
	
	// @Disabled
	@Test
	void testMockEmailService() {

		// make sure the mock is initialized
		assertNotNull(mockEmailService);
		assertNotNull(messagingController);		
		
		// setup data
		String message = "This is a test email.";
		
		// define your condition for the Mock...mimicking...
		when(mockEmailService.send(message)).thenReturn(true);
		
		// execute test...
		// mock call...
		Boolean returnStatus = messagingController.sendEmail(message);
		
		// Validate test...
		assertTrue(returnStatus);

	}

}
