package com.user.service.services.impl;

import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> listOfUsers = userRepository.findAll();
        for(User user : listOfUsers) {
            ArrayList ratings =  restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(), ArrayList.class);
            user.setRatings(ratings);
        }
        return listOfUsers;
    }

    @Override
    public User getUserById(String id) {

        //get user from database with the help of user repo
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server !! :"+id));

        //fetch ratings of above user from RATING-SERVICE
        ArrayList ratings =  restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(), ArrayList.class);
        logger.info("",ratings);
        user.setRatings(ratings);
        return user;
    }

}
