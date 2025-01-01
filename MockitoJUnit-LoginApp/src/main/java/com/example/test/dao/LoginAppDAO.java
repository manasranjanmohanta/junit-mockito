package com.example.test.dao;

public interface LoginAppDAO {
	public int authenticate(String username, String password);

	public void addUser(String user, String role);
}
