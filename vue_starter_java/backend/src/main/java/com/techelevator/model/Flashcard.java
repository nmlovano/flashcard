package com.techelevator.model;

public class Flashcard {

private int cardId;
private int deckId; 
private String frontText;
private String backText;
private String cardTag;

public int getCardId() {
    return cardId;
}
public void setCardId(int cardId) {
    this.cardId = cardId;
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
public String getCardTag() {
    return cardTag;
}
public void setCardTag(String cardTag) {
    this.cardTag = cardTag;
}
}
