/**
 * 
 */
package com.booking.hotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.booking.hotelbooking.entity.Hotel;

/**
 * 
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>,
JpaSpecificationExecutor<Hotel> {
	
	List<Hotel> findByCityIgnoreCase(String city);

}
