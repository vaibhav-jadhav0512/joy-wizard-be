package com.joy.wizard.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joy.wizard.be.auth.models.User;
import com.joy.wizard.be.model.Question;
import com.joy.wizard.be.service.JoyWizardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/joy")
public class JoyController {

	@Autowired
	private JoyWizardService service;

	@GetMapping("/get/questions")
	public ResponseEntity<List<Question>> getQuestions() {
		return new ResponseEntity<>(service.getQuestions(), HttpStatus.OK);
	}

	@PostMapping("/save/survey")
	public ResponseEntity<Integer> saveSurvey(@RequestBody List<Question> answers, @AuthenticationPrincipal User user) {
		for (Question ans : answers) {
			ans.setUid(user.getUid());
		}
		log.info(answers.toString());
		return new ResponseEntity<>(service.saveSurvey(answers), HttpStatus.CREATED);
	}

	@GetMapping("/get/all/answers")
	public ResponseEntity<List<Question>> getAnswers() {
		return new ResponseEntity<>(service.getAnswers(), HttpStatus.OK);
	}

	@PostMapping("/save/question")
	public ResponseEntity<Integer> saveQuestion(@RequestBody Question question) {
		return new ResponseEntity<>(service.saveQuestion(question), HttpStatus.CREATED);
	}

}
