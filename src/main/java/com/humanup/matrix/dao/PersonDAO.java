package com.humanup.matrix.dao;

import com.humanup.matrix.dao.entities.Person;
import com.humanup.matrix.dao.entities.Profile;
import com.humanup.matrix.vo.PersonVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {

  Person findByMailAdresses(String mailAdresses);
  List<Person> findAll();
  Person findById(long id);
  @Query("SELECT p FROM Person p WHERE lower(p.profile.profileTitle) like %:profileTitle% ")
  List<Person> findListProfilesByProfileTitle(String profileTitle);
}
