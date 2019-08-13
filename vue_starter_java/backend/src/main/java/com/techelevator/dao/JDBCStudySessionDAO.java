package com.techelevator.dao;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.CardDeck;
import com.techelevator.model.User;


public class JDBCStudySessionDAO implements StudySessionDAO{
	private JdbcTemplate jdbcTemplate;
	CardDeck myDeck;
	User aUser;
	LocalDateTime date; 
	
	//this method doesn't work in SQL how it is right now
	
	@Override
	public void createNewStudySession(int deckId, int num_right, LocalDateTime date,  int userId) {
		jdbcTemplate.update("INSERT into audit VALUES (?, ?, ?, ?)", myDeck.getDeckId(), num_right, date, aUser.getId());	
		
	}

	@Override
	public void updateNumberRight() {
			jdbcTemplate.update("UPDATE card" + "SET ? = ?" + "WHERE ? = ?");

		}
		
	}

}
