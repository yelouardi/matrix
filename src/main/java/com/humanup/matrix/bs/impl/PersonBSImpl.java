package com.humanup.matrix.bs.impl;

import com.humanup.matrix.bs.PersonBS;
import com.humanup.matrix.dao.PersonDAO;
import com.humanup.matrix.dao.entities.Person;
import com.humanup.matrix.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonBSImpl implements PersonBS {

  @Autowired
  private PersonDAO personDAO;

  @Override
  public boolean createPerson(PersonVO personVO) {
      Person personToSave =new Person.Builder()
          .setFirstName(personVO.getFirstName())
          .setLastName(personVO.getLastName())
          .setMailAdresses(personVO.getMailAdresses())
          .setBirthDate(personVO.getBirthDate())
          .build();
    return  personDAO.save(personToSave)!=null;
  }

  @Override
  public PersonVO findPersonByMailAdresses(String mailAdresses) {
    Optional<Person>  personFinded = Optional.ofNullable(personDAO.findByMailAdresses(mailAdresses));
    if(personFinded.isPresent()) {
      return new PersonVO.Builder()
          .setMailAdresses(personFinded.get().getMailAdresses())
          .setBirthDate(personFinded.get().getBirthDate())
          .setFirstName(personFinded.get().getFirstName())
          .setLastName(personFinded.get().getLastName())
          .build();
    }
    return null;
  }

  @Override
  public List<PersonVO> findListPerson() {
    return personDAO.findAll()
        .stream()
        .map(personFinded -> new PersonVO.Builder()
            .setMailAdresses(personFinded.getMailAdresses())
            .setBirthDate(personFinded.getBirthDate())
            .setFirstName(personFinded.getFirstName())
            .setLastName(personFinded.getLastName())
            .build())
        .collect(Collectors.toList());

  }
}
