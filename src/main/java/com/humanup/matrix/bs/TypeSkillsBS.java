package com.humanup.matrix.bs;
import com.humanup.matrix.vo.TypeSkillsVO;
import java.util.List;

public interface TypeSkillsBS {
    boolean createTypeSkills(TypeSkillsVO typeSkillsVO);
    TypeSkillsVO findByTypeSkillsTitle(String titleSkill);
    List<TypeSkillsVO> findListTypeSkills();
    List <TypeSkillsVO> findListTypeSkillsByTitle(String title);
}
