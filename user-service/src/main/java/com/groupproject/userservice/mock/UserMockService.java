package com.groupproject.userservice.mock;

import com.groupproject.userservice.domain.Profile;
import com.groupproject.userservice.domain.User;
import com.groupproject.userservice.repository.UserRepository;
import com.groupproject.userservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserMockService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public UserMockService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @PostConstruct
    public void mockDatabase() {
        Profile profile = new Profile();
        profile.setFirstName("Rick");
        profile.setLastName("Sanchez");
        profile.setGender("Unsure");
        profile.setPhone("+380506661234");
        profile.setAvatar("https://pm1.narvii.com/6482/48e8a9393c5bcfd04c40e8ec5add3d6d3dec2a84_hq.jpg");
        profile = profileRepository.save(profile);

        User user = new User();
        user.setEmail("rick@sanchez.com");
        user.setProfile(profile);
        user.setPassword("MyMorty");
        user = userRepository.save(user);
    }
}
