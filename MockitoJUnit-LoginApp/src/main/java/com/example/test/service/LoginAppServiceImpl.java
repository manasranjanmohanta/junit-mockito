package com.example.test.service;

import com.example.test.dao.LoginAppDAO;

public class LoginAppServiceImpl implements LoginAppService {
	private LoginAppDAO loginAppDAO;
	
	public LoginAppServiceImpl(LoginAppDAO loginAppDAO) {
		this.loginAppDAO = loginAppDAO;
	}



	@Override
	public boolean login(String username, String password) {
		if (username.equals("") || password.equals("")) {
			throw new IllegalArgumentException("Empty credentials");
		}
		
		int count = loginAppDAO.authenticate(username, password);
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}



	@Override
	public String registerUser(String user, String role) {
		if (!role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor")) {
			loginAppDAO.addUser(user, role);
			return "User Added";
		}
		else {
			return "User not Addred";
		}
	}

}
