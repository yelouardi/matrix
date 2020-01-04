package com.humanup.matrix.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of= {"profileId","profileTitle","profileDescription","personList"})
@Entity
@Table(name = "profile_person")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
     Long profileId;
     String profileTitle;
     String profileDescription;
    @OneToMany(mappedBy="profile",fetch=FetchType.LAZY)
     List<Person> personList;

}
