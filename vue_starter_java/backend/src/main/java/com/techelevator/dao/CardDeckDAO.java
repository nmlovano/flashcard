package com.techelevator.dao;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

import com.techelevator.model.CardDeck;
import com.techelevator.model.Flashcard;

public interface CardDeckDAO {
	public void saveFlashcard(int deckId, String frontText, String backText, String cardTag);

	public Flashcard getFlashcardByCardId(int cardId);

	public void assignFlashcardToDeck(int cardId, int deckId);

	public void removeFlashcardFromDeck(int cardId);

	public List<Flashcard> getFlashcardsForDeckOrdered(int deckId);

	public List<Flashcard> getFlashcardsForDeckShuffled(int deckId);

	public void updateFlashcard(int cardId, String frontText, String backText, String cardTag);

	public void updateFlashcardStudySession(Flashcard flashcard);

	public void saveCardDeck(String name, String description, int userId);

	public List<CardDeck> getCardDecksByUserName(String userName);

	public CardDeck getCardDeckByDeckId(int deckId);

	public void updateCardDeck(int deckId, String name, String description, int userId);

	public List<Tag> getAllTags(String tagNames);

	public List<Flashcard> searchCardsByTags(String tagNames);

	public List<Flashcard> getAllCommonCards(String frontText, String backText);

	public void deleteCardDeck(int deckId);
	
	public List<CardDeck> getCardDecksByUserId(int userId);
	
	public List<CardDeck> getAllDecks();

}
