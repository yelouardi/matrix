package com.humanup.matrix.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.humanup.matrix.bs.SkillBS;
import com.humanup.matrix.vo.SkillVO;

@RestController
public class SkillController {
	  @Autowired
	  private SkillBS skillBS;
	  
	  @RequestMapping(value="/skill", method=RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity createSkill(@RequestBody SkillVO skill){
	    Optional<Object> findskill = Optional.ofNullable(skillBS.findSkillByLibelle(skill.getLibelle()));

	    if(findskill.isPresent()){
	      return ResponseEntity.status(HttpStatus.FOUND).body("This Skill is Founded");
	    }
	    skillBS.createSkill(skill);
	    return ResponseEntity.status(HttpStatus.OK).body(skill);
	  }


	  @RequestMapping(value="/skill", method=RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity getSkillInfo(@RequestParam(value="libelle", defaultValue="Java") String email){
	    Optional<SkillVO> findSkill = Optional.ofNullable(skillBS.findSkillByLibelle(email));
	    if(findSkill.isEmpty()){
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(findSkill.get());
	  }

	  @RequestMapping(value="/skill/all", method=RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity getAllSkillInfo(){
	    List<SkillVO> findskills = skillBS.findListSkill();

	    if(findskills.isEmpty()){
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(findskills);
	  }

//	  @RequestMapping(value="/person/all/profile", method=RequestMethod.GET)
//	  @ResponseBody
//	  public ResponseEntity getProfilePersons(@RequestParam(value="title", defaultValue="Spring Developer") String profileTitle){
//	    Optional<List<PersonVO>> findProfile = Optional.ofNullable(personBS.findListProfilesByProfileTitle(profileTitle));
//	    if(findProfile.isEmpty()){
//	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Title not Found");
//	    }
//	    return ResponseEntity.status(HttpStatus.OK).body(findProfile.get());
//	  }
}
