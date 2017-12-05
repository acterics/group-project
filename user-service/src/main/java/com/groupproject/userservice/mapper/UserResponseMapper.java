package com.groupproject.userservice.mapper;

import com.groupproject.userservice.domain.Profile;
import com.groupproject.userservice.domain.User;
import com.groupproject.userservice.model.response.UserResponse;
import org.springframework.stereotype.Component;

/**
 * Created by rick on 03.12.17.
 */
@Component
public class UserResponseMapper {
    public UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        Profile profile = user.getProfile();
        userResponse.setFirstName(profile.getFirstName());
        userResponse.setLastName(profile.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setGender(profile.getGender());
        userResponse.setPhone(profile.getPhone());
        userResponse.setAvatar(profile.getAvatar());
        return userResponse;
    }
}
