package com.gearing.dojooverflow.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gearing.dojooverflow.models.Answer;
import com.gearing.dojooverflow.models.Question;
import com.gearing.dojooverflow.services.AnswerService;
import com.gearing.dojooverflow.services.QuestionService;

import jakarta.validation.Valid;

@Controller
public class DojoOverflowController {
	@Autowired
	private QuestionService questionServ;
	@Autowired
	private AnswerService answerServ;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Question> questions = questionServ.getAllQuestions();
		
		model.addAttribute("questions", questions);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String createQuestion(Model model, @ModelAttribute("newQuestion") Question newQuestion) {
		
		return "questionform.jsp";
	}
	
	@GetMapping("/questions/{id}")
	public String questionDisplay(Model model, @PathVariable Long id, @ModelAttribute("newAnswer") Answer newAnswer) {
		Optional<Question> optionalQuest = questionServ.getQuestionById(id);
		if(optionalQuest.isEmpty())
			return "redirect:/";
		
		model.addAttribute("question", optionalQuest.get());
		
		return "answerform.jsp";
	}
	
	@PostMapping("/questions/add")
	public String addQuestion(Model model, @Valid @ModelAttribute("newQuestion") Question newQuestion,
			BindingResult result) {
		questionServ.submit(newQuestion, result);
		if(result.hasErrors())
			return "questionform.jsp";
		
		return "redirect:/";
	}
	
	@PostMapping("/questions/{questionId}/answer")
	public String addAnswer(Model model, @PathVariable Long questionId, @Valid @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("question", questionServ.getQuestionById(questionId).get());
			return "answerform.jsp";
		}
		
		answerServ.createAnswer(newAnswer);
		
		return "redirect:/questions/" + questionId;
	}
}
