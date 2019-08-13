package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

public class JdbcUserDAO implements UserDao {
	JdbcTemplate jdbcTemplate; 

	@Override
	public User saveUser(String userName, String password, String role, String first_name, String last_name,
			String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getValidUserWithPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		String sqlUserSelected="select * from users where username= ?";
		
		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlUserSelected, username);
		User thisUser = null;
		if (user.next()) {
			thisUser = new User();
			thisUser = getUserByUsername(user.getString("user_name"));

	}
		return thisUser; 

}
}