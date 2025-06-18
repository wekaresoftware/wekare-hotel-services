/**
 * 
 */
package com.booking.hotelbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotelbooking.entity.Hotel;
import com.booking.hotelbooking.repository.HotelRepository;

import jakarta.persistence.criteria.Predicate;

/**
 * 
 */
@Service
public class HotelSearchService {
	
	@Autowired private HotelRepository repo;

    public List<Hotel> search(Optional<String> city, Optional<String> country) {
        if (city.isPresent()) {
            return repo.findByCityIgnoreCase(city.get());
        }
        return repo.findAll();
    }

    public List<Hotel> advancedSearch(String city, String country, Double minLat, Double maxLat) {
        return repo.findAll((root, cq, cb) -> {
            List<Predicate> p = new ArrayList<>();
            p.add(cb.equal(cb.lower(root.get("city")), city.toLowerCase()));
            p.add(cb.equal(cb.lower(root.get("country")), country.toLowerCase()));
            p.add(cb.between(root.get("latitude"), minLat, maxLat));
            return cb.and(p.toArray(new Predicate[0]));
        });
    }
}
