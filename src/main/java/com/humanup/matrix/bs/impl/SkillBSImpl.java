package com.humanup.matrix.bs.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanup.matrix.bs.SkillBS;
import com.humanup.matrix.dao.SkillDAO;
import com.humanup.matrix.dao.entities.Skill;
import com.humanup.matrix.vo.SkillVO;

@Service
public class SkillBSImpl implements SkillBS {

	  @Autowired
	  private SkillDAO skillDAO;

	@Override
	public boolean createSkill(SkillVO skillVO) {
	    Skill skillToSave =new Skill.Builder()
	    		.setLibelle(skillVO.getLibelle())
	    		.setDescription(skillVO.getDescription())
	            .build();
	      return  skillDAO.save(skillToSave)!=null;
	}

	@Override
	public SkillVO findSkillByLibelle(String libelle) {
	    Optional<Skill>  skillFinded = Optional.ofNullable(skillDAO.findSkillByLibelle(libelle));
	    if(skillFinded.isPresent()) {
	      return new SkillVO.Builder()
	          .setLibelle(skillFinded.get().getLibelle())
	          .setDescription(skillFinded.get().getDescription())
	          .build();
	    }
	    return null;
	}

	@Override
	public List<SkillVO> findListSkillByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillVO> findListSkill() {
		 return skillDAO.findAll()
			        .stream()
			        .map(skillFinded -> new SkillVO.Builder()
			            .setLibelle(skillFinded.getLibelle())
			            .setDescription(skillFinded.getDescription())
			            .build())
			        .collect(Collectors.toList());
	}

}
