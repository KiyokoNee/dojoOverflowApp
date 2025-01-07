package com.gearing.dojooverflow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.dojooverflow.models.Question;
import com.gearing.dojooverflow.models.Tag;
import com.gearing.dojooverflow.repositories.QuestionRepository;
import com.gearing.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private QuestionRepository questionRepo;
	
	public List<String> splitAndTrimTags(String tagInput) {
		List<String> result = Arrays.asList(tagInput.split(","));
		
		for(int i = 0; i < result.size() ; i++) {
			result.set(i ,result.get(i).trim());
		}
		
		return result;
	}
	
	public void createTags(List<String> tagList) {
		for(String tagName : tagList)  {
			if(tagRepo.findBySubject(tagName).isEmpty()) {
				Tag newTag = new Tag();
				newTag.setSubject(tagName);
				tagRepo.save(newTag);
			}
		}
	}
	
	public void addTags(List<String> tagList, Long questionId) {
		for(String tag : tagList) {
			addTagToQuestion(tag, questionId);
		}
	}
	
	public void addTagToQuestion(String tagSubject, Long questionId) {
		Tag tag = tagRepo.findBySubject(tagSubject).get();
		Question question = questionRepo.findById(questionId).get();
		
		if(tag.getQuestions() == null)
			tag.setQuestions(new ArrayList<Question>());
		
		tag.getQuestions().add(question);
		
		tagRepo.save(tag);
	}
}
