package com.joy.wizard.be.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.joy.wizard.be.model.Question;

public class QuestionRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question q = new Question();
		q.setQid(rs.getString("qid"));
		q.setQuestion(rs.getString("question"));
		q.setInput(rs.getString("input"));
		return q;
	}

}
