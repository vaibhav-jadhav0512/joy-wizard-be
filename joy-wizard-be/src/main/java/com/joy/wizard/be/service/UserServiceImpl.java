package com.joy.wizard.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joy.wizard.be.auth.models.User;
import com.joy.wizard.be.exception.AdminNotFoundException;
import com.joy.wizard.be.repository.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public int createOrUpdateUser(User user) {
		return dao.createOrUpdateUser(user);
	}

	@Override
	public User getUserById(String uid) {
		return dao.getUserById(uid);
	}

	@Override
	public User getAdminById(String uid) {
		User user = new User();
		try {
			user = dao.getAdminById(uid);
		} catch (EmptyResultDataAccessException e) {
			log.error("Admin not found:{}", uid);
			throw new AdminNotFoundException("Admin user not found");
		}
		return user;
	}

}
