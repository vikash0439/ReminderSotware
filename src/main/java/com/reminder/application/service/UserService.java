package com.reminder.application.service;

import com.reminder.application.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
