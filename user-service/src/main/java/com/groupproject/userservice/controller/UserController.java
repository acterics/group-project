package com.groupproject.userservice.controller;

import com.groupproject.userservice.model.response.UserResponse;
import com.groupproject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rick on 03.12.17.
 */

@RestController
public class UserController {
    //TODO Implement tokens

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public UserResponse getUser() {
        //TODO Replace hardcoded id
        return userService.getUserById(2L);
    }


//    RequestMapping
//    @ResponseBody
//    public UserResponse getUserByEmail(@RequestParam("email") String email) {
//
//    }
}
