package com.gearing.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.dojooverflow.models.Answer;
import com.gearing.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
	
	List<Answer> findAllByQuestion(Question question);
	
	Optional<Answer> findById(Long id);
}
