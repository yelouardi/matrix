package com.humanup.matrix.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String description;

	protected Skill() {
	}

	public Skill(String libelle, String description) {
		this.libelle = libelle;
		this.description = description;
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

	@Override
	public String toString() {
		return String.format("Skill[id=%d, libelle='%s', description='%s']", id, libelle, description);
	}

	public static class Builder {

		private String libelle;
		private String description;

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

		public Skill build() {
			return new Skill(libelle, description);
		}

	}

}
