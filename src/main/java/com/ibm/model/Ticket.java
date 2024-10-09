package com.ibm.model;

import lombok.Data;

@Data
public class Ticket 
{
	private Integer ticketNumber;
	private String name;
	private String source;
	private String destination;
	private String flight_name;
	private String flght_date;
}
