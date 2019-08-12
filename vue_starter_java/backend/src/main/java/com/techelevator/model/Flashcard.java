package com.techelevator.model;

import java.util.List;

public class Flashcard {
	
	private int cardId;
	private int userId;
	private int deckId; 
	private List<Integer> allDeckIds;
	private String frontText;
	private String backText;
	private List<String> cardTag;
	private boolean isCorrect; 
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeckId() {
		return deckId;
	}
	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}
	public String getFrontText() {
		return frontText;
	}
	public void setFrontText(String frontText) {
		this.frontText = frontText;
	}
	public String getBackText() {
		return backText;
	}
	public void setBackText(String backText) {
		this.backText = backText;
	}
	public List<String> getCardTag() {
		return cardTag;
	}
	public void setCardTag(List<String> cardTags) {
		this.cardTag = cardTags;
	}
	public List<Integer> getAllDeckIds() {
		return allDeckIds;
	}
	public void setAllDeckIds(List<Integer> allDeckIds) {
		this.allDeckIds = allDeckIds;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
}


