package com.humanup.matrix.dao;

import com.humanup.matrix.dao.entities.Person;
import com.humanup.matrix.vo.PersonVO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonDAO extends CrudRepository<Person, Long> {

  Person findByMailAdresses(String mailAdresses);
  List<Person> findAll();
  Person findById(long id);
}
