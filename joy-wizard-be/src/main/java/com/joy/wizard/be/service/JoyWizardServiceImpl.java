package com.joy.wizard.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joy.wizard.be.model.Question;
import com.joy.wizard.be.repository.JoyWizardDao;

@Service
public class JoyWizardServiceImpl implements JoyWizardService {

	@Autowired
	private JoyWizardDao dao;

	@Override
	public List<Question> getQuestions() {
		return dao.getQuestions();
	}

	@Override
	public int saveSurvey(List<Question> answers) {
		return dao.saveSurvey(answers);
	}

	@Override
	public List<Question> getAnswers() {
		return dao.getAnswers();
	}

	@Override
	public int saveQuestion(Question question) {
		return dao.saveQuestion(question);
	}

}
