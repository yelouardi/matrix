package com.humanup.matrix.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of= {"id","libelle","description","typeSkills","persons"})
@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	 String libelle;
	 String description;

	@ManyToOne
	@JoinColumn(name = "typeId")
	 TypeSkills typeSkills;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "skills")
	 Set<Person> persons = new HashSet<>();

}
