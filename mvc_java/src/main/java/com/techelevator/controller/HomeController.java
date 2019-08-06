package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techelevator.model.CardDeckDAO;
import com.techelevator.model.UserDAO;

@Controller 
public class HomeController {
	private UserDAO userDAO;
	private CardDeckDAO cardDeckDAO;
	
	
@Autowired
	public HomeController(UserDAO userDAO, CardDeckDAO cardDeckDAO) {
		this.userDAO = userDAO;
		this.cardDeckDAO = cardDeckDAO;
	}

}
