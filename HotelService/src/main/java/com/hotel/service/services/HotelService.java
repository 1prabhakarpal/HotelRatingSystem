package com.hotel.service.services;

import com.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //get all
    List<Hotel> getAllHotels();


    //get single
    Hotel getHotelById(String id);
}
