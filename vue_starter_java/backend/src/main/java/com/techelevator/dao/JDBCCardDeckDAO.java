package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.html.HTML.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.CardDeck;
import com.techelevator.model.Flashcard;

@Component
public class JDBCCardDeckDAO implements CardDeckDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCCardDeckDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveFlashcard(int deckId, String frontText, String backText, String cardTag) {
		jdbcTemplate.update("INSERT into card(deck_id, card_front, card_back, card_tag) VALUES (?, ?, ?, ?)", deckId, frontText, backText, cardTag);
	}

	@Override
	public Flashcard getFlashcardByCardId(int cardId) {
		String sqlSearchForCard = "SELECT *" + "from card" + "where card_id = ?";

		SqlRowSet card = jdbcTemplate.queryForRowSet(sqlSearchForCard, cardId);
		Flashcard thisCard = null;
		if (card.next()) {
			thisCard = new Flashcard();
			thisCard = getFlashcardByCardId(card.getInt("card_id"));

		}
		return thisCard;
	}

	@Override
	public void assignFlashcardToDeck(int cardId, int deckId) {
		jdbcTemplate.update("update card set deck_id = ? where card_id = ?");

	}

	@Override
	public void removeFlashcardFromDeck(int cardId) {
		jdbcTemplate.batchUpdate("delete from card where card_id = ?");

	}

	@Override
	public List<Flashcard> getFlashcardsForDeckOrdered(int deckId) {
		List<Flashcard> allCardsForDeck = new ArrayList<>();
		String sqlAllCardsForDeck = "SELECT *" + "FROM card" + "WHERE deck_id = ?" + "ORDER by ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCardsForDeck, deckId);
		while (results.next()) {
			Flashcard allCards = mapRowToFlashcard(results);
			allCardsForDeck.add(allCards);
		}
		return allCardsForDeck;
	}
	

	@Override
	public List<Flashcard> getFlashcardsForDeckShuffled(int deckId) {
		List<Flashcard> allCardsShuffled = new ArrayList<>();
		String sqlAllCardsShuffled = "SELECT *" + "from card" + "where deck_id = ?" + "order by random()";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCardsShuffled, deckId);
		while (results.next()) {
			Flashcard allShuffled = mapRowToFlashcard(results);
			allCardsShuffled.add(allShuffled);
		}
		return allCardsShuffled;
	}

	@Override
	public void updateFlashcard(int cardId, String frontText, String backText, String cardTag) {
		jdbcTemplate.batchUpdate("UPDATE card" + "SET ? = ?" + "WHERE ? = ?");

	}

	@Override
	public void updateFlashcardStudySession(Flashcard flashcard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCardDeck(String name, String description, int userId) {
		jdbcTemplate.update("Insert into deck (deck_name, deck_description, user_id) VALUES (?, ?, ?)", name, description, userId);

	}

	@Override
	public List<CardDeck> getCardDecksByUserName(String userName) {
		String sqlDecksByUser = "select * from deck inner join users on deck.user_id = users.id where id = ?";
		SqlRowSet deezDecks = jdbcTemplate.queryForRowSet(sqlDecksByUser);
		List<CardDeck> allMyDecks = null;
		if (deezDecks.next()) {
			allMyDecks = new ArrayList<CardDeck>();
			allMyDecks = getCardDecksByUserName(userName);
		}
		return allMyDecks;
	}
	@Override
	public List<CardDeck> getCardDecksByUserId(int userId) {
		String sqlDecksByUserId = "select * from deck where user_id = ?";
		SqlRowSet allDecksByUserId = jdbcTemplate.queryForRowSet(sqlDecksByUserId, userId);
		List<CardDeck> allMyIdDecks = new ArrayList<CardDeck>();
		while (allDecksByUserId.next()) {
			CardDeck allTheseDecks = mapRowToCardDeck(allDecksByUserId);
			allMyIdDecks.add(allTheseDecks);
		}
		return allMyIdDecks;
	}

	@Override
	public CardDeck getCardDeckByDeckId(int deckId) {
		String sqlGetDeckByDeckId = "SELECT *" + "from deck" + "where deck_id = ?";
		SqlRowSet deck = jdbcTemplate.queryForRowSet(sqlGetDeckByDeckId, deckId);
		CardDeck thisDeck = null;
		if (deck.next()) {
			thisDeck = new CardDeck();
			thisDeck = getCardDeckByDeckId(deck.getInt("deck_id"));

		}
		return thisDeck;
	}

	@Override
	public void updateCardDeck(int deckId, String name, String description, int userId) {
		jdbcTemplate.batchUpdate("UPDATE deck" + "SET ? = ?" + "WHERE ? = ?");

	}

	@Override
	public List<Tag> getAllTags(String tagNames) {
		String sqlAllTags = "Select card_tag from card";
		SqlRowSet allTags = jdbcTemplate.queryForRowSet(sqlAllTags);
		List<Tag> allTheseTags = null;
		if (allTags.next()) {
			allTheseTags = new ArrayList<Tag>();
			allTheseTags = getAllTags(allTags.getString("card_tag"));
		}

		return allTheseTags;
	}

	@Override
	public List<Flashcard> searchCardsByTags(String tagNames) {
		String sqlGetTaggedCards = "Select * from card where card_tag like '%?%'";
		SqlRowSet matchingCards = jdbcTemplate.queryForRowSet(sqlGetTaggedCards, tagNames);
		List<Flashcard> allMatchedCards = null;
		if (matchingCards.next()) {
			allMatchedCards = new ArrayList<Flashcard>();
			allMatchedCards = searchCardsByTags("card_tag");
		}
		return allMatchedCards;
	}

	@Override
	public List<Flashcard> getAllCommonCards(String frontText, String backText) {
		String sqlGetCommon = "Select * from card where card_front = ? or card_back = ?";
		SqlRowSet commonCards = jdbcTemplate.queryForRowSet(sqlGetCommon, frontText, backText);
		List<Flashcard> listOfCards = null;
		if (commonCards.next()) {
			listOfCards = new ArrayList<Flashcard>();
			listOfCards = getAllCommonCards("card_front", "card_back");
		}
		return listOfCards;
	}

	public void deleteCardDeck(int deckId) {
		jdbcTemplate.batchUpdate("delete from deck " + "where deck_id = ?");
	}

	@Override
	public List<CardDeck> getAllDecks() {
		List<CardDeck> allDecks = new ArrayList<>();
		String sqlGetAllDecks = "SELECT * from deck";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDecks);
		while(results.next()) {
			CardDeck deckResult = mapRowToCardDeck(results);
			allDecks.add(deckResult);
		}
		return allDecks;
	}
	
	private CardDeck mapRowToCardDeck(SqlRowSet result) {
	    CardDeck cardDeck = new CardDeck();
	    cardDeck.setDeckId(result.getInt("deck_id"));
	    cardDeck.setName(result.getString("deck_name"));
	    cardDeck.setDescription(result.getString("deck_description"));
	    cardDeck.setUserId(result.getInt("user_id"));
	    return cardDeck;
	}
	
	private Flashcard mapRowToFlashcard(SqlRowSet result) {
	    Flashcard flashcard = new Flashcard();
	    flashcard.setCardId(result.getInt("card_id"));
	    flashcard.setDeckId(result.getInt("deck_id"));
	    flashcard.setFrontText(result.getString("card_front"));
	    flashcard.setBackText(result.getString("card_back"));
	    flashcard.setCardTag(result.getString("card_tag"));
	    return flashcard;
	}

}
