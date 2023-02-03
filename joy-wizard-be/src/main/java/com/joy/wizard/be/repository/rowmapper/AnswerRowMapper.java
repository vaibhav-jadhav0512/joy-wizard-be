package com.joy.wizard.be.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.joy.wizard.be.model.Question;

public class AnswerRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question q = new Question();
		q.setQid(rs.getString("qid"));
		q.setUid(rs.getString("uid"));
		q.setAns(rs.getString("avg(ans)"));
		q.setQuestion(rs.getString("question"));
		return q;
	}

}