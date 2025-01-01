package com.example.test.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.test.dao.LoginAppDAO;

public class LoginAppServiceTest {
	private static LoginAppDAO loginAppDAOMock;
	private static LoginAppService loginAppService;
	
	@BeforeAll
	public static void setUpOnce() {
		// Create Mock/fake/dummy object
		loginAppDAOMock = Mockito.mock(LoginAppDAO.class); // mock(-) generates InMemory class implementing
													// LoginAppDAO having null method definition for authenticate(-) method
	
		// Create Service class object
		loginAppService = new LoginAppServiceImpl(loginAppDAOMock);
	}
	
	@AfterAll
	public static void clearOnce() {
		loginAppDAOMock = null;
		loginAppService = null;
	}
	
	// Test methods
	@Test
	public void testLoginWithValidCredentials() {
		// Provide Stub (Temporary functionality) for DAO authenticate() method
		Mockito.when(loginAppDAOMock.authenticate("Manas", "P")).thenReturn(1);
		
		// Unit Testing
		Assertions.assertTrue(loginAppService.login("Manas", "P"));
		
	}
	
	@Test
	public void testLoginWithInValidCredentials() {
		// Provide Stub (Temporary functionality) for DAO authenticate() method
		Mockito.when(loginAppDAOMock.authenticate("Manas", "Pr")).thenReturn(0);
		
		// Unit Testing
		Assertions.assertFalse(loginAppService.login("Manas", "Pr"));
		
	}
	
	@Test
	public void testLoginWithNoCredentials() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			loginAppService.login("", "");	 
		});
	}
	
	@Test
	public void testRegisterWithSpy() {
		LoginAppDAO loginAppDAOSpy = Mockito.spy(LoginAppDAO.class);
//		LoginAppDAO loginAppDAOSpy = Mockito.mock(LoginAppDAO.class);
		LoginAppService loginAppService = new LoginAppServiceImpl(loginAppDAOSpy);
		loginAppService.registerUser("raja", "admin");
		loginAppService.registerUser("suresh", "visitor");
		loginAppService.registerUser("jani", "");
		
		// Behaviour testing (check how many time method is called or not that time we use spy object)
		Mockito.verify(loginAppDAOSpy, Mockito.times(1)).addUser("raja", "admin");
		Mockito.verify(loginAppDAOSpy, Mockito.times(0)).addUser("suresh", "visitor");
		Mockito.verify(loginAppDAOSpy, Mockito.never()).addUser("jani", "");
		
	}
}
