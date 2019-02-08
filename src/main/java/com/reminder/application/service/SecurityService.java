package com.reminder.application.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
