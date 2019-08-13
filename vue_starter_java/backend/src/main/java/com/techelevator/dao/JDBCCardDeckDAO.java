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
		String sqlSearchForDeck = "SELECT *" + "FROM card" + "WHERE deck_id = ?" + "ORDER by ?";
		SqlRowSet deck = jdbcTemplate.queryForRowSet(sqlSearchForDeck, deckId);
		List<Flashcard> thisDeck = null;
		if (deck.next()) {
			thisDeck = new ArrayList<Flashcard>();
			thisDeck = getFlashcardsForDeckOrdered(deck.getInt("deck_id"));

		}
		return thisDeck;
	}

	@Override
	public List<Flashcard> getFlashcardsForDeckShuffled(int deckId) {
		String sqlShuffleDeck = "SELECT *" + "from card" + "where deck_id = ?" + "order by random()";
		SqlRowSet deck = jdbcTemplate.queryForRowSet(sqlShuffleDeck, deckId);
		List<Flashcard> thisDeck = null;
		if (deck.next()) {
			thisDeck = new ArrayList<Flashcard>();
			thisDeck = getFlashcardsForDeckShuffled(deck.getInt("deck_id"));

		}
		return thisDeck;
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
		String sqlDecksByUserId = "select * from deck where userId = ?";
		SqlRowSet allDecksByUserId = jdbcTemplate.queryForRowSet(sqlDecksByUserId);
		List<CardDeck> allMyIdDecks = null;
		if (allDecksByUserId.next()) {
			allMyIdDecks = new ArrayList<CardDeck>();
			allMyIdDecks = getCardDecksByUserId(userId);
		}
		return allMyIdDecks;
	}

	@Override
	public List<CardDeck> getAllCardDecks() {
		String sqlGetDecks = "SELECT *" + "from deck";
		SqlRowSet decks = jdbcTemplate.queryForRowSet(sqlGetDecks);
		List<CardDeck> thisDeck = null;
		if (decks.next()) {
			thisDeck = new ArrayList<CardDeck>();
			thisDeck = getAllCardDecks();

		}
		return thisDeck;
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
	public List<CardDeck> getAllDecks(String name, String description) {
		String sqlGetAllDecks = "SELECT * from deck";
		SqlRowSet allDecks = jdbcTemplate.queryForRowSet(sqlGetAllDecks, name, description);
		List<CardDeck> listAllDecks = null;
		if(allDecks.next()) {
			listAllDecks = new ArrayList <CardDeck>();
			listAllDecks = getAllDecks("deck_name", "deck_description");
		}
		return listAllDecks;
	}

}
