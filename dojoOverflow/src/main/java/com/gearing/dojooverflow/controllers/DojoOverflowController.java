package com.gearing.dojooverflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gearing.dojooverflow.models.Question;
import com.gearing.dojooverflow.repositories.QuestionRepository;

@Controller
public class DojoOverflowController {
	@Autowired
	private QuestionRepository questionRepo;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Question> questions = questionRepo.findAll();
		
		model.addAttribute("questions", questions);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String createQuestion(Model model) {
		
		return "questionform.jsp";
	}
	
	@GetMapping("/questions/{id}")
	public String questionDisplay(Model model) {
		
		return "answerform.jsp";
	}
}
