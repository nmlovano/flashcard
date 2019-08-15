package com.techelevator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dao.CardDeckDAO;
import com.techelevator.model.UserDao;
import com.techelevator.model.Flashcard;

@RestController
@CrossOrigin
public class SearchController {

	private UserDao userDAO;
	private CardDeckDAO cardDeckDAO;

	@Autowired
	public SearchController(UserDao userDAO) {
		this.userDAO = userDAO;
		this.cardDeckDAO = cardDeckDAO;
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String conductSearch(HttpSession session, RedirectAttributes ra,
			@RequestParam(required = false) String[] tagNames) {
		Set<Flashcard> cardSet = new HashSet<Flashcard>();
		if (tagNames != null) {
			List<Flashcard> cardList = new ArrayList<>();
			for (int i = 0; i < tagNames.length; i++) {
				List<Flashcard> cards = cardDeckDAO.searchCardsByTags(tagNames[i]);
				for (Flashcard card : cards) {
					if (!cardList.isEmpty()) {
						boolean isDuplicate = false;
						for (int j = 0; j < cardList.size(); j++) {
							if (cardList.get(j).getCardId() == card.getCardId()) {
								isDuplicate = true;
							}
						}
						if (!isDuplicate) {
							cardList.add(card);
						}
					} else {
						cardList.add(card);
					}
				}
			}
			ra.addFlashAttribute("searchReturns", cardList);
		}
		return "redirect:/search";
	}

}