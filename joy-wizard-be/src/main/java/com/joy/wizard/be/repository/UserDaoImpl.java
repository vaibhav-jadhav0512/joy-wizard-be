package com.joy.wizard.be.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.joy.wizard.be.auth.models.User;
import com.joy.wizard.be.queries.UserQueries;
import com.joy.wizard.be.repository.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public int createOrUpdateUser(User user) {
		Map<String, Object> params = new HashMap<>();
		params.put("uid", user.getUid());
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		params.put("picture", user.getPicture());
		params.put("emailVerified", user.isEmailVerified());
		return template.update(UserQueries.CREATE_OR_UPDATE_USER, params);
	}

	@Override
	public User getUserById(String uid) {
		Map<String, Object> params = new HashMap<>();
		params.put("uid", uid);
		return template.queryForObject(UserQueries.GET_USER_BY_ID, params, new UserRowMapper());
	}

	@Override
	public User getAdminById(String uid) {
		Map<String, Object> params = new HashMap<>();
		params.put("uid", uid);
		return template.queryForObject(UserQueries.GET_ADMIN_BY_ID, params, new UserRowMapper());
	}

}
