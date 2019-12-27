package com.humanup.matrix.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.humanup.matrix.dao.entities.Skill;

public interface SkillDAO extends CrudRepository<Skill, Long> {

	  Skill findSkillByLibelle(String libelle);
	  List<Skill> findAll();
	  Skill findById(long id);

	 // List<Skill> findListSkillByType(String type);
}
