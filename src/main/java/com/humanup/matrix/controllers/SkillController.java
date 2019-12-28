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
	  
	  @RequestMapping(value="/skill", method=RequestMethod.POST,consumes={ "application/json"})
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
	  public ResponseEntity getSkillInfo(@RequestParam(value="libelle", defaultValue="C++") String libelle){
	    Optional<SkillVO> findSkill = Optional.ofNullable(skillBS.findSkillByLibelle(libelle));
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

	  @RequestMapping(value="/skill/all/type", method=RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity getTypeSkills(@RequestParam(value="type", defaultValue="audace") String typeSkill){
	    Optional<List<SkillVO>> findSkill = Optional.ofNullable(skillBS.findListSkillByTypeTitle(typeSkill));
	    if(findSkill.isEmpty()){
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Type not Found");
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(findSkill.get());
	  }
}
