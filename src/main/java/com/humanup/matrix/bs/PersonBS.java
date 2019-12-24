package com.humanup.matrix.bs;

import com.humanup.matrix.vo.PersonVO;

import java.util.List;

public interface PersonBS {
  boolean createPerson(PersonVO person);
  PersonVO findPersonByMailAdresses(String mailAdresses);
  List<PersonVO> findListPerson();
}
