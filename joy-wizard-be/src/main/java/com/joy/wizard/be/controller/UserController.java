package com.joy.wizard.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joy.wizard.be.auth.models.User;
import com.joy.wizard.be.service.UserService;

@RestController
@RequestMapping("/joy-wizard")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/user/create-update")
	public ResponseEntity<Integer> createOrUpdateUser(@AuthenticationPrincipal User user) {
		return new ResponseEntity<>(service.createOrUpdateUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/get/user")
	public ResponseEntity<User> getUserById(@AuthenticationPrincipal User user) {
		return new ResponseEntity<>(service.getUserById(user.getUid()), HttpStatus.OK);
	}

	@PostMapping("/get/admin")
	public ResponseEntity<User> getAdminById(@AuthenticationPrincipal User user) {
		return new ResponseEntity<>(service.getAdminById(user.getUid()), HttpStatus.OK);
	}
}
