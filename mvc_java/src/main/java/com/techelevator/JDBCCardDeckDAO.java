package com.techelevator;

import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.html.HTML.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.CardDeck;
import com.techelevator.model.Flashcard;

@Component
public class JDBCCardDeckDAO implements CardDeckDAO {
	private JdbcTemplate jdbcTemplate;

@Autowired
public JDBCCardDeckDAO (DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate (dataSource);
}

@Override
public void saveFlashcard(int deckId, String frontText, String backText, String[] tagId) {
	jdbcTemplate.update("INSERT into card (deck_id, card_front, card_back, card_tag) VALUES (?, ?, ?, ?)");
	
}

@Override
public void deleteFlashcard(int cardId) {
	jdbcTemplate.update("DELETE from card where card_id = ?");
	
}

@Override
public Flashcard getFlashcardByCardId(int cardId) {
	String sqlSearchForCard = "SELECT *"+
							  "from card"+
							  "where card_id = ?";
	
	SqlRowSet card = jdbcTemplate.queryForRowSet(sqlSearchForCard, cardId);
	Card thisCard = null;
	if(card.next()) {
		thisCard = new Card();
		
	}
	return null;
}

@Override
public void assignFlashcardToDeck(int cardId, int deckId) {
	// TODO Auto-generated method stub
	
}

@Override
public void removeFlashcardFromDeck(int cardId, int deckId) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Flashcard> getFlashcardsForDeckOrdered(int deckId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Flashcard> getFlashcardsForDeckShuffled(int deckId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void updateFlashcard(int cardId, String frontText, String backText, String[] tagId) {
	// TODO Auto-generated method stub
	
}

@Override
public void updateFlashcardStudySession(Flashcard flashcard) {
	// TODO Auto-generated method stub
	
}

@Override
public void saveCardDeck(String name, String description) {
	jdbcTemplate.update("Insert into deck (deck_name, deck_description) VALUES (?, ?)");
	
}

@Override
public List<CardDeck> getCardDecksByUserName(String userName) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<CardDeck> getAllCardDecks() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CardDeck getCardDeckByDeckId(int deckId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void updateCardDeck(int deckId, String name, String description) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Tag> getAllTags() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Flashcard> searchCardsByTags(String tagNames) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Integer> getAllDeckIdsForCard(int cardId) {
	// TODO Auto-generated method stub
	return null;
}
	
}
