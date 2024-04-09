package com.rating.service.services;

import com.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating createRating(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();


    //get all ratings by user id
    List<Rating> getRatingsByUserId(String userId);


    //get all by hotel id
    List<Rating> getRatingByHotelId(String hotelId);

}
