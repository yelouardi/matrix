package com.humanup.matrix.vo;

public class SkillVO {

	private String libelle;
	private String description;
	
	protected SkillVO() {
	}

	public SkillVO(String libelle, String description) {
		this.libelle = libelle;
		this.description = description;
	}


	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
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

		public SkillVO build() {
			return new SkillVO(libelle, description);
		}

	}
}
