package com.syksy2021.WeekTwoFriendList;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syksy2021.WeekTwoFriendList.domain.Friend;


@Controller
public class FriendController {
	
	ArrayList<Friend> friends = new ArrayList<>();

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("friend", new Friend());
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Friend friend, Model model) {
		if (friend != null) {
			friends.add(friend);
		}
		model.addAttribute("friend", friend);
		model.addAttribute("friends", friends);
		return "result";
	}
}
