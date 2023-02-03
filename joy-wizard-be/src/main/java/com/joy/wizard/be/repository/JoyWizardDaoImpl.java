package com.joy.wizard.be.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.joy.wizard.be.model.Question;
import com.joy.wizard.be.queries.JoyWizardQueries;
import com.joy.wizard.be.repository.rowmapper.AnswerRowMapper;
import com.joy.wizard.be.repository.rowmapper.QuestionRowMapper;

@Repository
public class JoyWizardDaoImpl implements JoyWizardDao {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Question> getQuestions() {
		return template.query(JoyWizardQueries.GET_QUESTIONS, new QuestionRowMapper());
	}

	@Override
	public int saveSurvey(List<Question> answers) {
		for (Question q : answers) {
			Map<String, Object> params = new HashMap<>();
			params.put("uid", q.getUid());
			params.put("qid", q.getQid());
			params.put("ans", q.getAns());
			template.update(JoyWizardQueries.SAVE_SURVEY, params);
		}
		return 1;
	}

	@Override
	public List<Question> getAnswers() {
		return template.query(JoyWizardQueries.GET_ANSWERS, new AnswerRowMapper());
	}

	@Override
	public int saveQuestion(Question q) {
		Map<String, Object> params = new HashMap<>();
		int max = template.queryForObject(JoyWizardQueries.GET_MAX_QID, params, Integer.class);
		params.put("qid", String.valueOf(max + 1));
		params.put("question", q.getQuestion());
		params.put("input", q.getInput());
		return template.update(JoyWizardQueries.SAVE_QUESTION, params);
	}

}
