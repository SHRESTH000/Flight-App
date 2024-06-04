package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FlightDao;
import com.project.model.Flight;
import com.project.request.FlightRequest;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao flightDao;
	
	public Flight saveFlight(FlightRequest inputflightRequest) {
		
		Flight flight=new Flight();
		
		flight.setSource(inputflightRequest.getSource());
		flight.setDestination(inputflightRequest.getDestination());
		flight.setCompany(inputflightRequest.getCompany());
		
		Flight savedFlight=flightDao.save(flight);
		
		if(savedFlight== null) {
			throw new RuntimeException("Some error During saving Flight");
		}
		return savedFlight;
	}
	
	public List<Flight> FindFlight(String source, String destination){
		
		
		List<Flight> Allflightdata=flightDao.getFlightBySourceAndDestination(source, destination);
		
		if(Allflightdata.isEmpty()) {
			throw new RuntimeException("No flight is Found");
		}
		
		
		return Allflightdata;
	}
	public List<Flight> getAllFlights(){
		
		List<Flight> allFlights=flightDao.findAll();
		
		if(allFlights.isEmpty()) {
			
			throw new RuntimeException("No Flights is Found");
		}
		
		return allFlights;
	}

}
