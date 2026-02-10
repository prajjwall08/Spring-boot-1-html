package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.GreetingService;

@Controller

public class Page {
	@Autowired
	private GreetingService greetingService;
	
	@GetMapping("/")
	public String home() {
		return "welcome";
	}
	
	@RequestMapping("/submitname") 
	public String submitName(@RequestParam ("username") String userName, Model model) {
		String greetings = greetingService.generateMessage(userName);
		model.addAttribute("message", greetings);
		return "greeting";
	}
} 
