/**
 * 
 */
package com.booking.hotelbooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotelbooking.entity.Hotel;
import com.booking.hotelbooking.service.HotelSearchService;

/**
 * 
 */
@RestController
@RequestMapping("/api/hotels")
public class HotelSearchController {
	
	@Autowired private HotelSearchService service;

    @GetMapping("/search")
    public List<Hotel> search(
        @RequestParam Optional<String> city,
        @RequestParam Optional<String> country) {
        return service.search(city, country);
    }

    @GetMapping("/advanced")
    public List<Hotel> advanced(
        @RequestParam String city,
        @RequestParam String country,
        @RequestParam Double minLat,
        @RequestParam Double maxLat) {
        return service.advancedSearch(city, country, minLat, maxLat);
    }

}
