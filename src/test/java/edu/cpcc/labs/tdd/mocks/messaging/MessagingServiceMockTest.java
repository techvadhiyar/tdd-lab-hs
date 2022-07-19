package edu.cpcc.labs.tdd.mocks.messaging;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.cpcc.labs.tdd.mocks.messaging.MessagingController;
import edu.cpcc.labs.tdd.mocks.messaging.MessagingService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessagingServiceMockTest {
	
	@Mock
	MessagingService  mockSMSService;
	
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
		String message = "This is a test.";
		
		// define your condition...
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

}
