package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight,Long> {
	
	@Query(nativeQuery = true, value = "select * from flight_data where source= :source and destination=:destination")
	public List<Flight> getFlightBySourceAndDestination(String source,String destination);
}
