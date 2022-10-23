package com.bob.assg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
public class ShuffleServiceTest {

	@Test
	public void testShuffleArray() {
		LogClient logClient = mock(LogClient.class);		
		ShuffleService service = new ShuffleService(logClient);
		int[] arr = service.genereateArray(10);
		assertEquals(10,arr.length);
	}
	
}
