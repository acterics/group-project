package com.groupproject.userservice.model.response;

import lombok.Data;

/**
 * Created by rick on 03.12.17.
 */

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private String avatar;
    private String message;
}
