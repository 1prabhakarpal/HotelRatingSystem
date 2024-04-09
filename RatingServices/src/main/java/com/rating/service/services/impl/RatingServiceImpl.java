package com.rating.service.services.impl;

import com.rating.service.entities.Rating;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    /**
     * @param rating
     * @return
     */
    @Override
    public Rating createRating(Rating rating) {
        System.out.println("Inside createRating method of RatingServiceImpl ");
        return ratingRepository.save(rating);
    }

    /**
     * @return
     */
    @Override
    public List<Rating> getAllRatings() {
        System.out.println("Inside getAllRatings method of RatingServiceImpl ");
        return ratingRepository.findAll();
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        System.out.println("Inside getRatingsByUserId method of RatingServiceImpl ");
        return ratingRepository.findByUserId(userId);
    }

    /**
     * @param hotelId
     * @return
     */
    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        System.out.println("Inside getRatingByHotelId method of RatingServiceImpl ");
        return ratingRepository.findByHotelId(hotelId);
    }
}
