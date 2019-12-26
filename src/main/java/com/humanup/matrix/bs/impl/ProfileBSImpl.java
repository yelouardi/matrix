package com.humanup.matrix.bs.impl;

import com.humanup.matrix.bs.ProfileBS;
import com.humanup.matrix.dao.ProfileDAO;
import com.humanup.matrix.dao.entities.Profile;
import com.humanup.matrix.vo.PersonVO;
import com.humanup.matrix.vo.ProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileBSImpl implements ProfileBS {

    @Autowired
    private ProfileDAO profileDAO;

    @Override
    public boolean createProfile(ProfileVO profileVO) {
        Profile profileToSave =new Profile.Builder()
                .setProfileTitle(profileVO.getProfileTitle())
                .setProfileDescription(profileVO.getProfileDescription())
                .build();
        return  profileDAO.save(profileToSave)!=null;
    }

    @Override
    public ProfileVO findByProfileTitle(String profileTitle) {
        Optional<Profile> profileFinded = Optional.ofNullable(profileDAO.findByProfileTitle(profileTitle));
        if(profileFinded.isPresent()) {
            return new ProfileVO.Builder()
                    .setProfileTitle(profileFinded.get().getProfileTitle())
                    .setProfileDescription(profileFinded.get().getProfileDescription())
                    .build();
        }
        return null;
    }

    @Override
    public List<ProfileVO> findListProfile() {
        return profileDAO.findAll()
                .stream()
                .map(profileFinded -> new ProfileVO.Builder()
                        .setProfileTitle(profileFinded.getProfileTitle())
                        .setProfileDescription(profileFinded.getProfileDescription())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public ProfileVO findListProfileByTitle(String title) {
        Optional<Profile> profileFinded = Optional.ofNullable(profileDAO.findByProfileTitle(title));
        if(profileFinded.isPresent()) {
            return new ProfileVO.Builder()
                    .setProfileTitle(profileFinded.get().getProfileTitle())
                    .setProfileDescription(profileFinded.get().getProfileDescription())
                    .setPersonList(
                            profileFinded.get().getPersonList()
                                    .stream()
                                    .map(person -> new PersonVO.Builder()
                                            .setBirthDate(person.getBirthDate())
                                            .setFirstName(person.getFirstName())
                                            .setLastName(person.getLastName())
                                            .setMailAdresses(person.getMailAdresses()).build())
                                    .collect(Collectors.toList())
                    )
                    .build();
        }
        return null;
    }

}
