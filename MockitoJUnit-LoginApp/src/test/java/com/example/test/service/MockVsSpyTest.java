package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockVsSpyTest {
	
	@Test
	public void testList() {
		List<String> listMock = Mockito.mock(ArrayList.class); // Mock
		List<String> listSpy = Mockito.spy(new ArrayList()); // spy
		listMock.add("table");
		Mockito.when(listMock.size()).thenReturn(10);
		listSpy.add("table");
		
		
		System.out.println(listMock.size() + " " + listSpy.size());
	}

}
