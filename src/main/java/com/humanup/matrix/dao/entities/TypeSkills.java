package com.humanup.matrix.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of= {"typeId","titleSkill","skillList"})
@Entity
@Table(name = "type_skills")
public class TypeSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long typeId;
	 String titleSkill;

	@OneToMany(mappedBy="typeSkills",fetch=FetchType.LAZY)
	 List<Skill> skillList;

}
