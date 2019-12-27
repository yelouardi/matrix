package com.humanup.matrix.controllers;

import com.humanup.matrix.bs.ProfileBS;
import com.humanup.matrix.bs.TypeSkillsBS;
import com.humanup.matrix.vo.TypeSkillsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TypeSkillsController {
    @Autowired
    private TypeSkillsBS typeSkillsBS;



    @RequestMapping(value="/typeskills", method= RequestMethod.POST)
    @ResponseBody

    public ResponseEntity createTypeSkills(@RequestBody TypeSkillsVO typeSkills){
        Optional<Object> findTypeSkills = Optional.ofNullable(typeSkillsBS.findByTypeSkillsTitle(typeSkills.getTitleSkill()));

        if(findTypeSkills.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This type is Founded");
        }
        typeSkillsBS.createTypeSkills(typeSkills);
        return ResponseEntity.status(HttpStatus.OK).body(typeSkillsBS);
    }

    @RequestMapping(value="/typeskills", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getTypeInfo(@RequestParam(value="title", defaultValue="Spring Boot") String title){
        Optional<List<TypeSkillsVO>> findType = Optional.ofNullable(typeSkillsBS.findListTypeSkillsByTitle(title));
        if(findType.isEmpty()){
            Optional<TypeSkillsVO> findTypeSkillsTitle = Optional.ofNullable(typeSkillsBS.findByTypeSkillsTitle(title));
            if(findTypeSkillsTitle.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This type is not Found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(findTypeSkillsTitle.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(findType.get());
    }

    @RequestMapping(value="/typeskills/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAlltypeInfo(){
        List<TypeSkillsVO> findType = typeSkillsBS.findListTypeSkills();

        if(findType.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findType);
    }

}
