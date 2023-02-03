package com.joy.wizard.be.service;

import com.joy.wizard.be.auth.models.User;

public interface UserService {

	int createOrUpdateUser(User user);

	User getUserById(String uid);

	User getAdminById(String uid);

}
