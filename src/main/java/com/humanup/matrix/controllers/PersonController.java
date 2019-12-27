package com.humanup.matrix.controllers;

import com.humanup.matrix.bs.PersonBS;
import com.humanup.matrix.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class PersonController {
  @Autowired
  private PersonBS personBS;


  @RequestMapping(value="/person", method=RequestMethod.POST)
  @ResponseBody
  public ResponseEntity createPerson(@RequestBody PersonVO person){
    Optional<Object> findPerson = Optional.ofNullable(personBS.findPersonByMailAdresses(person.getMailAdresses()));

    if(findPerson.isPresent()){
      return ResponseEntity.status(HttpStatus.FOUND).body("This User is Founded");
    }
    personBS.createPerson(person);
    return ResponseEntity.status(HttpStatus.OK).body(person);
  }


  @RequestMapping(value="/person", method=RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getPersonInfo(@RequestParam(value="email", defaultValue="robot@sqli.com") String email){
    Optional<PersonVO> findPerson = Optional.ofNullable(personBS.findPersonByMailAdresses(email));
    if(findPerson.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(findPerson.get());
  }

  @RequestMapping(value="/person/all", method=RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getAllPersonInfo(){
    List<PersonVO> findPersons = personBS.findListPerson();

    if(findPersons.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(findPersons);
  }

  @RequestMapping(value="/person/all/profile", method=RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getProfilePersons(@RequestParam(value="title", defaultValue="Spring Developer") String profileTitle){
    Optional<List<PersonVO>> findProfile = Optional.ofNullable(personBS.findListProfilesByProfileTitle(profileTitle));
    if(findProfile.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Title not Found");
    }
    return ResponseEntity.status(HttpStatus.OK).body(findProfile.get());
  }
}
