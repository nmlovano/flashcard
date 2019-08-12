package com.techelevator.model;

public class Flashcard {

	private int cardId;
<<<<<<< HEAD
	private int userId;
	private int deckId;
	private List<Integer> allDeckIds;
	private String frontText;
	private String backText;
	private List<String> cardTag;
	private boolean isCorrect;

=======
	private int deckId; 
	private String frontText;
	private String backText;
	private String cardTag;
	
>>>>>>> fe80b4c73c892003efdc23c67186e5341d48bc6a
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
<<<<<<< HEAD

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

=======
>>>>>>> fe80b4c73c892003efdc23c67186e5341d48bc6a
	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}
<<<<<<< HEAD

	public List<Integer> getAllDeckIds() {
		return this.allDeckIds;
	}

	public void setAllDeckIds(List<Integer> allDeckIds) {
		this.allDeckIds = allDeckIds;
	}

=======
>>>>>>> fe80b4c73c892003efdc23c67186e5341d48bc6a
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
<<<<<<< HEAD

	public List<String> getCardTag() {
		return cardTag;
	}

	public void setCardTag(List<String> cardTags) {
		this.cardTag = cardTags;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
=======
	public String getCardTag() {
		return cardTag;
	}
	public void setCardTag(String cardTag) {
		this.cardTag = cardTag;
>>>>>>> fe80b4c73c892003efdc23c67186e5341d48bc6a
	}
	
	
}
