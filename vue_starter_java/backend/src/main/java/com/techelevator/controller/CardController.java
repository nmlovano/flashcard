package com.techelevator.controller;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

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
import com.techelevator.model.Flashcard;

@RestController
@CrossOrigin
@RequestMapping("/card")

public class CardController {

	private AuthProvider authProvider;

	private CardDeckDAO cardDeckDAO;

	@Autowired
	public CardController(CardDeckDAO cardDeckDAO, AuthProvider authProvider) {
		this.cardDeckDAO = cardDeckDAO;
		this.authProvider = authProvider;
	}

	@RequestMapping(path = "?cardId={id}", method = RequestMethod.GET)
	public Flashcard getCardById(@RequestParam int cardId) {
		return cardDeckDAO.getFlashcardByCardId(cardId);
	}

	@RequestMapping(path = "?savecard={savecard}", method = RequestMethod.POST)
	public void saveNewCard(@RequestBody int deckId, String frontText, String backText, String[] tagId) {
		cardDeckDAO.saveFlashcard(deckId, frontText, backText, tagId);

	}

	@RequestMapping(path = "?assign={assign}", method = RequestMethod.POST)
	public void assignCardToDeck(@RequestBody int cardId, int deckId) {
		cardDeckDAO.assignFlashcardToDeck(cardId, deckId);
	}

	@RequestMapping(path = "?id={cardId}", method = RequestMethod.DELETE)
	public void removeCardFromDeck(@RequestParam int cardId, int deckId) {
		Flashcard thisCard = cardDeckDAO.getFlashcardByCardId(cardId);
		if (thisCard.getUserId() == authProvider.getCurrentUser().getId()) {
			cardDeckDAO.removeFlashcardFromDeck(cardId, deckId);
			;
		}
		System.out.println(authProvider.getCurrentUser().toString());

	}

	@RequestMapping(path = "?id={deckId}", method = RequestMethod.GET)
	public List<Flashcard> getCardByDeckOrdered(@RequestParam int deckId) {
		return cardDeckDAO.getFlashcardsForDeckOrdered(deckId);
	}

	@RequestMapping(path = "?shuffled={deckId}", method = RequestMethod.GET)
	public List<Flashcard> getCardByDeckShuffled(@RequestParam int deckId) {
		return cardDeckDAO.getFlashcardsForDeckShuffled(deckId);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void updateCard(@RequestBody int cardId, String frontText, String backText, String[] tagId) {
		cardDeckDAO.updateFlashcard(cardId, frontText, backText, tagId);
	}

	@RequestMapping(path = "?tag={tag}", method = RequestMethod.GET)
	public List<Flashcard> searchCardsByTag(@RequestParam String tagNames) {
		return cardDeckDAO.searchCardsByTags(tagNames);
	}

	@RequestMapping(path = "?common={common}", method = RequestMethod.GET)
	public List<Flashcard> getCommonCards(@RequestParam String frontText, String backText) {
		return cardDeckDAO.getAllCommonCards(frontText, backText);
	}

	@RequestMapping(path = "?tags={tags}", method = RequestMethod.GET)
	public List<Tag> getAllTags(String tagNames) {
		return cardDeckDAO.getAllTags(tagNames);
	}
}
