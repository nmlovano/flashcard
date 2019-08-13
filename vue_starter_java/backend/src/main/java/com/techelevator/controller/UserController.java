package com.techelevator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.UserDao;
import com.techelevator.model.CardDeck;
import com.techelevator.model.User;

@RestController
@CrossOrigin
public class UserController {

	private UserDao userDAO;

	@Autowired
	public UserController(UserDao userDAO) {
		this.userDAO = userDAO;
	}
	@RequestMapping(path = "/user", method = RequestMethod.GET) 
	public User getUserByUsername(@RequestParam String username) {
		User thisUser = new User(); 
		return thisUser; 
	}

	@RequestMapping(path = "/users/new", method = RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "newUser";
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/users/new";
		}

		userDAO.saveUser(user.getUsername(), user.getPassword(), user.getRole(), user.getFirstName(),
				user.getLastName(), user.getEmail());
		return "redirect:/login";
	}
	

}
