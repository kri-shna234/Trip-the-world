package com.ibm.model;

import lombok.Data;

@Data
public class Passenger 
{
	private String name;
	private String source;
	private String destination;
	private String flight_name;
	private String flght_date;
}
