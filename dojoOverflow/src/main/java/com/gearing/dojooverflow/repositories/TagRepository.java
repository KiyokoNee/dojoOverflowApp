package com.gearing.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.dojooverflow.models.Question;
import com.gearing.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	
	List<Tag> findAllByQuestions(Question question);
	
	Optional<Tag> findBySubject(String subject);
}
