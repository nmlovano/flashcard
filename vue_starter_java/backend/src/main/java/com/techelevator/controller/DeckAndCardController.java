package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.CardDeckDAO;
import com.techelevator.model.CardDeck;

@RestController
@CrossOrigin
@RequestMapping("/deck")
public class DeckAndCardController {

	private AuthProvider authProvider;

	private CardDeckDAO cardDeckDAO;

	@Autowired
	public DeckAndCardController(CardDeckDAO cardDeckDAO, AuthProvider authProvider) {
		this.cardDeckDAO = cardDeckDAO;
		this.authProvider = authProvider;
	}

	@RequestMapping(path = "?username={username}", method = RequestMethod.GET)
	public List<CardDeck> getDeckByUsername(@RequestParam String username) {
		return cardDeckDAO.getCardDecksByUserName(username);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void saveNewDeck(@RequestBody CardDeck deck, String name, String description) {
		cardDeckDAO.saveCardDeck(name, description);

	}

	@RequestMapping(path = "?id={deckId}", method = RequestMethod.DELETE)
	public void deleteDeck(@RequestParam int deckId) {
		CardDeck thisDeck = cardDeckDAO.getCardDeckByDeckId(deckId);
		if (thisDeck.getUserId() == authProvider.getCurrentUser().getId()) {
			cardDeckDAO.deleteCardDeck(deckId);
		}
		System.out.println(authProvider.getCurrentUser().toString());

	}
	
	@RequestMapping(path = "?id={deckId}", method = RequestMethod.GET)
	public CardDeck getDeckById(@RequestParam int deckId) {
		CardDeck thisDeck = cardDeckDAO.getCardDeckByDeckId(deckId);
		return thisDeck;
	}

}