package com.humanup.matrix.dao.entities;

import javax.persistence.*;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String description;

	@ManyToOne
	@JoinColumn(name = "typeId")
	private TypeSkills typeSkills;

	protected Skill() {
	}

	public Skill(String libelle, String description,TypeSkills typeSkills) {
		this.libelle = libelle;
		this.description = description;
		this.typeSkills = typeSkills;
	}

	public Long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	public TypeSkills getTypeSkills() {
		return this.typeSkills;
	}

	@Override
	public String toString() {
		return String.format("Skill[id=%d, libelle='%s', description='%s']", id, libelle, description);
	}

	public static class Builder {

		private String libelle;
		private String description;
		private TypeSkills typeSkills;

		public Builder() {
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setLibelle(String libelle) {
			this.libelle = libelle;
			return this;
		}

		public Builder setTypeSkills(TypeSkills typeSkills) {
			this.typeSkills = typeSkills;
			return this;
		}

		public Skill build() {
			return new Skill(libelle, description,typeSkills);
		}

	}

}
