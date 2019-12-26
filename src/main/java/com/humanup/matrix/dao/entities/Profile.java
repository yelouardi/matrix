package com.humanup.matrix.dao.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile_person")
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long profileId;
    private String profileTitle;
    private String profileDescription;



    @OneToMany
    private List<Person> personList;

    protected Profile() {}

    public Profile(String profileTitle, String profileDescription) {
        this.profileTitle = profileTitle;
        this.profileDescription = profileDescription;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                profileId, profileTitle, profileDescription);
    }


    public Long getId() {
        return this.profileId;
    }
    public String getProfileTitle() {
        return this.profileTitle;
    }
    public String getProfileDescription() {
        return this.profileDescription;
    }
    public List<Person> getPersonList() {
        return personList;
    }

    public static class Builder{

        private String profileTitle;
        private String profileDescription;

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

        public Profile build(){
            return new Profile( profileTitle,  profileDescription);
        }
    }

}
