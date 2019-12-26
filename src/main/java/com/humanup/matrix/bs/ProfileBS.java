package com.humanup.matrix.bs;
import com.humanup.matrix.vo.ProfileVO;
import java.util.List;

public interface ProfileBS {
    boolean createProfile(ProfileVO profile);
    ProfileVO findByProfileTitle(String profileTitle);
    List<ProfileVO> findListProfile();
     ProfileVO findListProfileByTitle(String title);
}
