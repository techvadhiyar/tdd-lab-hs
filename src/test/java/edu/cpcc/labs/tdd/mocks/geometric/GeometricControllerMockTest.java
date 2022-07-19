package edu.cpcc.labs.tdd.mocks.geometric;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// NOTE: Integrates JUnit5 with Mockito
@ExtendWith(MockitoExtension.class) 
class GeometricControllerMockTest {
	
	// NOTE: creates a mock instance...
	@Mock
	GeometricCalculator calculator;
	
	@Mock
	Drawable drawable;
	
	@Mock
	Rotatable rotatable;
	
	// NOTE: creates an instance of the controller and injects the mocks into the controller by calling the 
	// constructor and using constructor injection.  
	@InjectMocks
	GeometricController controller;	
	

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
	@DisplayName("Testing Geometric Controller with mocks.")
	void testGeometricControllerWithMocks() {
		
		// this is just a safety test...to ensure that I have a valid mock...
		assertNotNull(calculator);
		assertNotNull(drawable);
		assertNotNull(rotatable);
		assertNotNull(controller);
		
		// Setup my data...
		Double radius = 10.0;
		Double expectedArea = Math.PI * Math.pow(radius, 2);
		String expectedDrawableResponse = "I am drawing myself.";
		String expectedRotatableResponse = "I am rotating myself.";
		
		// Setup my mock recommendation...mimicking....
		when(calculator.area(new GeometricFigureDimension())).thenReturn(expectedArea);  
		when(drawable.draw()).thenReturn(expectedDrawableResponse);
		when(rotatable.rotate()).thenReturn(expectedRotatableResponse);
		
		// NOTE: we don't need this anymore since we are Mocking the calculator....
		// GeometricCalculator calculator = null;
		// we are injecting a mock calculator into the controller....
				
		// NOTE: I don't need to do this since I am injecting my mocks into the 
		// controller through the @InjectMocks annotation...that creates an instance
		// of the controller...
		// GeometricController controller = new GeometricController(calculator);
		
		// execute the calculate test.
		Double receivedArea = controller.areaOfCircle(radius);		
		// validate...
		assertEquals(expectedArea, receivedArea);		
		
		// execute the drawable test...
		String receivedDrawableResponse = controller.draw();
		assertEquals(expectedDrawableResponse, receivedDrawableResponse);	
		
		
		// execute the rotatable test...
		String receivedRotatableResponse = controller.rotate();
		assertEquals(expectedRotatableResponse, receivedRotatableResponse);	
		
	}

}
