package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CardDeckDAO;
import com.techelevator.model.CardDeck;

@RestController
@CrossOrigin
@RequestMapping("/deck")
public class DeckAndCardController {
	
	private CardDeckDAO cardDeckDAO;
@Autowired
public DeckAndCardController(CardDeckDAO cardDeckDAO) {
		this.cardDeckDAO = cardDeckDAO;
	}
@RequestMapping (path = "?username={username}", method = RequestMethod.GET)
public List<CardDeck> getDeckByUsername(@RequestParam String username) {
		return cardDeckDAO.getCardDecksByUserName(username); 
}
@RequestMapping (path = "", method = RequestMethod.POST)
public void saveNewDeck(@RequestBody CardDeck deck, String name, String description) {
	cardDeckDAO.saveCardDeck(name, description);
	
	
}
@RequestMapping (path = "", method = RequestMethod.DELETE)
public void deleteDeck() {
	
	
}

}
