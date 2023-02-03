package com.joy.wizard.be.service;

import java.util.List;

import com.joy.wizard.be.model.Question;

public interface JoyWizardService {

	List<Question> getQuestions();

	int saveSurvey(List<Question> answers);

	List<Question> getAnswers();

	int saveQuestion(Question question);

}
