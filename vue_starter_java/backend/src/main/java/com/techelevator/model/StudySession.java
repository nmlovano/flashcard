package com.techelevator.model;

import java.time.LocalDateTime;

public class StudySession {
	
	private int num_right; 
	private LocalDateTime date;

	public int getNum_right() {
		return num_right;
	}
	public void setNum_right(int num_right) {
		this.num_right = num_right;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
