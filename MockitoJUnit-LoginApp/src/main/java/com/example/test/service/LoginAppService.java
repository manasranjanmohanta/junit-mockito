package com.example.test.service;

public interface LoginAppService {
	public boolean login(String username, String password);
	
	public String registerUser(String user, String role);
}
