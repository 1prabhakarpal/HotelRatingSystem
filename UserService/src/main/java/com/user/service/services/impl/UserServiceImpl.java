package com.user.service.services.impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            Rating [] ratingArray =  restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(),Rating[].class);
            logger.info("",ratingArray);

            List<Rating> ratings = Arrays.stream(ratingArray).toList();

            List<Rating> ratingList =ratings.stream().map(rating ->{
                //api call to hotel service to get the hotel
                //http://localhost:8082/hotels
                System.out.println("http://localhost:8802/hotels/"+rating.getHotelId());
                ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
                Hotel hotel = forEntity.getBody();
                logger.info("Response Status Code: ",forEntity.getStatusCode());
                //set the hotel to rating
                rating.setHotel(hotel);
                //return the rating
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratingList);
        }
        return listOfUsers;
    }

    @Override
    public User getUserById(String id) {

        //get user from database with the help of user repo
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server !! :"+id));

        //fetch ratings of above user from RATING-SERVICE
        Rating [] ratingArray =  restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getUserId(),Rating[].class);
        logger.info("",ratingArray);

        List<Rating> ratings = Arrays.stream(ratingArray).toList();

        List<Rating> ratingList =ratings.stream().map(rating ->{
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels
            System.out.println("http://localhost:8802/hotels/"+rating.getHotelId());
            ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("Response Status Code: ",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

}
