package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users
    List<User> getAllUser();

    //get single user of given userId
    User getUserById(String id);

    //delete user
    //void deleteUser(String id);

    //update user of given user id
    //User updateUser(User user);
}
