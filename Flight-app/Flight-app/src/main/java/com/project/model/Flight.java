package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flight_data")
@Data
public class Flight {
	
	@Id
	@Column(name="Flight_Data")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "Source", nullable = false)
	private String source;
	@Column(name = "Destination", nullable = false)
	private String destination;
	@Column(name = "company", nullable = false)
	private String company;
	

}
