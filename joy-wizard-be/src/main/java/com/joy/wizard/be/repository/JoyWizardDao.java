package com.joy.wizard.be.repository;

import java.util.List;

import com.joy.wizard.be.model.Question;

public interface JoyWizardDao {

	List<Question> getQuestions();

	int saveSurvey(List<Question> answers);

	List<Question> getAnswers();

	int saveQuestion(Question question);

}
