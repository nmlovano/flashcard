package com.techelevator.controller;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.dao.CardDeckDAO;
import com.techelevator.model.CardDeck;
import com.techelevator.model.Flashcard;

@RestController
@CrossOrigin
public class CardController {

private AuthProvider authProvider;

private CardDeckDAO cardDeckDAO;

@Autowired
public CardController(CardDeckDAO cardDeckDAO, AuthProvider authProvider) {
    this.cardDeckDAO = cardDeckDAO;
    this.authProvider = authProvider;
}

@RequestMapping(path = "/cardId={id}", method = RequestMethod.GET)
public Flashcard getCardById(@RequestParam int cardId) {
    return cardDeckDAO.getFlashcardByCardId(cardId);
}

@RequestMapping(path = "/", method = RequestMethod.POST)
public void saveNewCard(@RequestBody Flashcard card) { 
    System.out.println("saveNewCard()");
    cardDeckDAO.saveFlashcard(card.getDeckId(), card.getFrontText(), card.getBackText(), card.getCardTag());
}


@RequestMapping(path = "/assign", method = RequestMethod.POST)
public void assignCardToDeck(@RequestBody int cardId, int deckId) {
    cardDeckDAO.assignFlashcardToDeck(cardId, deckId);
}

@RequestMapping(path = "/deckOrder/{deckId}", method = RequestMethod.GET)
public List<Flashcard> getCardByDeckOrdered(@PathVariable int deckId) {
	List<Flashcard> allCardsOrdered = cardDeckDAO.getFlashcardsForDeckOrdered(deckId);
    return allCardsOrdered;
    
}

@RequestMapping(path = "/shuffled={deckId}", method = RequestMethod.GET)
public List<Flashcard> getCardByDeckShuffled(@RequestParam int deckId) {
    return cardDeckDAO.getFlashcardsForDeckShuffled(deckId);
}

@RequestMapping(path = "/update", method = RequestMethod.PUT)
public void updateCard(@RequestBody int cardId, String frontText, String backText, String cardTag) {
    cardDeckDAO.updateFlashcard(cardId, frontText, backText, cardTag);
}

@RequestMapping(path = "/tag={tag}", method = RequestMethod.GET)
public List<Flashcard> searchCardsByTag(@RequestParam String tagNames) {
    return cardDeckDAO.searchCardsByTags(tagNames);
}

@RequestMapping(path = "/common", method = RequestMethod.GET)
public List<Flashcard> getCommonCards(@RequestParam String frontText, String backText) {
    return cardDeckDAO.getAllCommonCards(frontText, backText);
}

@RequestMapping(path = "/tags", method = RequestMethod.GET)
public List<Tag> getAllTags(String tagNames) {
    return cardDeckDAO.getAllTags(tagNames);
}
}