package com.humanup.matrix.vo;

import java.util.List;

public class ProfileVO {
    private String profileTitle;
    private String profileDescription;
    private List<PersonVO> personList;

    public ProfileVO() {
    }

    public ProfileVO(String profileTitle, String profileDescription) {
        this.profileTitle = profileTitle;
        this.profileDescription = profileDescription;
    }

    public String getProfileTitle() {
        return this.profileTitle;
    }
    public String getProfileDescription() {
        return this.profileDescription;
    }
    public List<PersonVO> getPersonList() {
        return personList;
    }
    public static class Builder{
        private String profileTitle;
        private String profileDescription;
        private List<PersonVO> personList;
        public Builder() {
        }

        public Builder setProfileTitle(String profileTitle) {
            this.profileTitle = profileTitle;
            return this;
        }
        public Builder setProfileDescription(String profileDescription) {
            this.profileDescription = profileDescription;
            return this;
        }

        public ProfileVO build() {
            return new ProfileVO(profileTitle, profileDescription);
        }

        public Builder setPersonList(List<PersonVO> personList) {
            this.personList = personList;
            return this;
        }
    }

}
