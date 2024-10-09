package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.model.Passenger;
import com.ibm.model.Ticket;
import com.ibm.service.TicketService;

@Controller
public class WelcomeController 
{
	@Autowired
	private TicketService ts;
  @GetMapping("/home")	
  public String welcome()
  {
	  return "welcome";
  }
  @GetMapping("/book")
  public String form()
  {
	  return "userdata";
  }
  @PostMapping("/bookTicket")
  public String bookTicket(Passenger p,Model m)
  {
	  Ticket ticket = ts.bookTic(p);
	  m.addAttribute("tic",ticket);
	  System.out.println(ticket);
	  return"ticketInfo";
  }
  @GetMapping("/get")
  public String getTic()
  {
	  return "getform";
  }
  @GetMapping("/getTicket")
  public String getTicket(@RequestParam Integer ticketNumber, Model model) {
      Ticket ticket =ts.getTicket(ticketNumber);
      if (ticket != null) {
          model.addAttribute("tic", ticket);
          return "ticketInfo"; 
      } else {
          model.addAttribute("error", "Ticket not found");
          return "getform";
      }
  }

  @GetMapping("/details")
  public String details()
  {
	  return "contact";
  }
}
