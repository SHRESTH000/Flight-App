package com.project.request;

import lombok.Data;

@Data
public class FlightRequest {

	private int flight_ID;
	private String source;
	private String destination;
	private String company;
}
