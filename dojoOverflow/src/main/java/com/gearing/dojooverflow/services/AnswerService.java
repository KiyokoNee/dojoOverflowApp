package com.gearing.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.dojooverflow.models.Answer;
import com.gearing.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepo;
	
	public void createAnswer(Answer answer) {
		answerRepo.save(answer);
	}
}
