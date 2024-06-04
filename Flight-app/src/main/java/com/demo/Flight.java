package com.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String destination;
    private String source;
    private String company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", source=" + source + ", company=" + company
				+ "]";
	}
	public Flight(String destination, String source, String company) {
		super();
		this.destination = destination;
		this.source = source;
		this.company = company;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
