package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techelevator.CardDeckDAO;
import com.techelevator.UserDAO;

@Controller 
public class HomeController {
	private UserDAO userDAO;
//	private CardDeckDAO cardDeckDAO;
	
	
	@Autowired
		public HomeController(UserDAO userDAO) {
			this.userDAO = userDAO;
//			this.cardDeckDAO = cardDeckDAO;
	}

}
