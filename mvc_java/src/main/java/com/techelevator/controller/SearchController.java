package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.SafeHtml.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.Flashcard;
import com.techelevator.model.CardDeckDAO;
import com.techelevator.model.UserDAO;

@Controller
public class SearchController {
	
	private UserDAO userDAO;
	private CardDeckDAO cardDeckDAO;

@Autowired
public SearchController(UserDAO userDAO, CardDeckDAO cardDeckDAO) {
	this.userDAO = userDAO;
	this.cardDeckDAO = cardDeckDAO;
}
@RequestMapping(path = "/search", method = RequestMethod.GET)
public String searchTags(HttpSession session, ModelMap map) {
	List<Tag> tagList = cardDeckDAO.getAllTags();
	Map<Integer, String> tagMap = new HashMap<>();
	session.setAttribute("tags", tagList);
	for (Tag tag : tagList) {
		tagMap.put(tag.getTagId(), tag.getName());
	}
	map.addAttribute("tagMap", tagMap);
	return "searchCard";
}

public String conductSearch(HttpSession session, RedirectAttributes ra,
		@RequestParam(required = false) String[] tagNames) {
	// Set<Flashcard> cardSet = new HashSet<>();
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