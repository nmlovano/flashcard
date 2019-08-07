package com.techelevator;

import java.util.List;

import javax.swing.text.html.HTML.Tag;


import com.techelevator.model.CardDeck;
import com.techelevator.model.Flashcard;


public interface CardDeckDAO {
public void saveFlashcard(int deckId, String frontText, String backText, String[] tagId);
	
	public void deleteFlashcard(int cardId);
	
	public Flashcard getFlashcardByCardId(int cardId);
	
	public void assignFlashcardToDeck(int cardId, int deckId);
	
	public void removeFlashcardFromDeck(int cardId, int deckId);
	
	public List<Flashcard> getFlashcardsForDeckOrdered(int deckId);
	
	public List<Flashcard> getFlashcardsForDeckShuffled(int deckId);
	
	public void updateFlashcard(int cardId, String frontText, String backText, String[] tagId);
	
	public void updateFlashcardStudySession(Flashcard flashcard);
	
	public void saveCardDeck(String name, String description);
	
	public List<CardDeck> getCardDecksByUserName(String userName);
	
	public List<CardDeck> getAllCardDecks();
	
	public CardDeck getCardDeckByDeckId(int deckId);
	
	public void updateCardDeck(int deckId, String name, String description);
	
	public List<Tag> getAllTags();
	
	public List<Flashcard> searchCardsByTags(String tagNames);
	
	public List<Flashcard> getAllCommonCards(String frontText, String backText);

}

