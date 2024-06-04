package com.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Flight;
import com.project.request.FlightRequest;
import com.project.service.FlightService;

@RestController
@RequestMapping("/flight/app/flight/v1")
public class FlightController {
	
	@Autowired
	private FlightService flightService;

	@PostMapping(value = "/save")
	public ResponseEntity<?> CreateFlight(@RequestBody FlightRequest flightRequest) {
		
		try {
			Flight flight=flightService.saveFlight(flightRequest);
			
			return ResponseEntity.ok().body(flight);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Some error occur during saving Flight");
			
		}
	}
	
	@GetMapping(value = "/getflight")
	public ResponseEntity<?> getFlight(@RequestParam Map<String, String> requestparam) throws Exception{
		
		String source=requestparam.get("source");
		String destination=requestparam.get("destination");
		try {
	
			List<Flight> allFlights=flightService.FindFlight(source, destination);
			return ResponseEntity.ok().body(allFlights);
			
		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body("some Error Occur");
		}		
	}
	
	@GetMapping(value = "/findAllFlight")
	public ResponseEntity<?> findAllFlights(){
		
		try {
			List<Flight> allFlights=flightService.getAllFlights();
			return ResponseEntity.ok().body(allFlights);
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("No Flights is Found");
			
		}
	}
}
