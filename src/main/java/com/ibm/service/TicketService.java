package com.ibm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.model.Passenger;
import com.ibm.model.Ticket;


@Service
public class TicketService 
{
	@Value("${american.airlines.book}")
	private String bookTicket;
	@Value("${american.airlines.get}")
	private String getTicket;
	RestTemplate rt=new RestTemplate();
   public Ticket bookTic(Passenger p)
   {
	   //RestTemplate rt=new RestTemplate();
	   ResponseEntity<Ticket> tic=rt.postForEntity(bookTicket, p,Ticket.class);
	  int statusCode = tic.getStatusCodeValue();
	   if(statusCode == 200)
	   {
		   Ticket ticket = tic.getBody();
		   return ticket;
	   }
	   return null;
   }
   public Ticket getTicket(Integer tic)
   {
	   String url=getTicket+tic;
	   ResponseEntity<Ticket> responseEntity = rt.getForEntity(url, Ticket.class);
	   if(responseEntity.getStatusCodeValue() == 200)
	   {
		   Ticket ticket = responseEntity.getBody();
		   return ticket;
	   }
	   return null;
   }
}
