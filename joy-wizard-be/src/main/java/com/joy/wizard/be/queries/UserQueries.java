package com.joy.wizard.be.queries;

public class UserQueries {

	public static final String CREATE_OR_UPDATE_USER = "INSERT INTO joywizard.`user` (uid, name, email, picture,emailVerified) VALUES(:uid, :name, :email, :picture,:emailVerified) "
			+ "ON DUPLICATE KEY UPDATE name=:name, email=:email, picture=:picture, emailVerified=:emailVerified";
	public static final String GET_USER_BY_ID = "SELECT uid, name, email, `role`, picture, emailVerified "
			+ "FROM joywizard.`user` WHERE uid=:uid";
	public static final String GET_ADMIN_BY_ID = "SELECT uid, name, email, `role`, picture, emailVerified "
			+ "FROM joywizard.`user` WHERE uid=:uid AND role='admin'";
}
