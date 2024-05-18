package com.session.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.session.ticket.dto.TicketDto;
import com.session.ticket.service.TicketService;

@Controller
public class TicketController {

	TicketService ticketService;

	@Autowired
	TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/listAlltickets")
	public String listTickets(Model model) {
		List<TicketDto> ticketDto = ticketService.listAllTickets();
		model.addAttribute("ticketDto", ticketDto);
		return "alltickets";
	}

	@GetMapping("/createTicket")
	public String createTicket(Model model) {

		TicketDto ticketDto = new TicketDto();
		model.addAttribute("ticketDto", ticketDto);
		return "createTicket-form";

	}

	@PostMapping("/processCreateTicket")
	public String processCreateTicket(@ModelAttribute("ticketDto") TicketDto ticketDto) {

		ticketService.createTicket(ticketDto);
		return "redirect:/listAlltickets";
	}

	@GetMapping("/edit/{id}")
	public String editTicket(@PathVariable("id") Long id, Model model) {

		TicketDto ticketDto = ticketService.findTicketById(id);
		model.addAttribute("ticket", ticketDto);
		return "edit-form";
	}

	@PostMapping("/processEdit/{id}")
	public String processEdit(@PathVariable("id") Long id, @ModelAttribute TicketDto ticketDto, Model model) {
		ticketDto.setId(id);
		ticketService.updateTicket(ticketDto);
		return "redirect:/listAlltickets";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable("id") Long id) {
		ticketService.deleteTicket(id);
		return "redirect:/listAlltickets";
	}

	@GetMapping("/searchTickets")
	public String searchTickets(@RequestParam(value = "query") String query, Model model) {

		List<TicketDto> ticketDto = ticketService.searchTickets(query);
		model.addAttribute("ticketDto", ticketDto);
		return "alltickets";

	}

	@GetMapping("/viewTicket/{id}")
	public String viewTicket(@PathVariable("id") Long id, Model model) {
		TicketDto ticketDto = ticketService.viewTicket(id);
		model.addAttribute("ticketDto", ticketDto);
		return "viewTicket";
	}

}
