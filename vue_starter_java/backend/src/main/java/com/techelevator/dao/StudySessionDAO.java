package com.techelevator.dao;

import java.time.LocalDateTime;

public interface StudySessionDAO {
	
	public void createNewStudySession(); 
	
	public void updateNumberRight(); 
	
	public void createNewStudySession(int deckId, int num_right, LocalDateTime date,  int userId);
}
