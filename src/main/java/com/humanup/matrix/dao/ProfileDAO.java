package com.humanup.matrix.dao;

import com.humanup.matrix.dao.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface ProfileDAO extends CrudRepository<Profile, Long> {

    Profile findByProfileTitle(String profileTitle);
    List<Profile> findAll();
    Profile findByProfileId(long profileId);
    @Query("SELECT p FROM Profile p WHERE lower(p.profileTitle) like %:profileTitle% ")
    List<Profile> findListProfilesByTitle(String profileTitle);

}
