package com.joy.wizard.be.repository;

import com.joy.wizard.be.auth.models.User;

public interface UserDao {

	int createOrUpdateUser(User user);

	User getUserById(String uid);

	User getAdminById(String uid);
}
