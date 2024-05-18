package com.session.ticket.service;

import java.util.List;

import com.session.ticket.dto.TicketDto;

public interface TicketService {

	List<TicketDto> listAllTickets();

	void createTicket(TicketDto ticketDto);

	TicketDto findTicketById(Long id);

	void updateTicket(TicketDto ticketDto);

	void deleteTicket(Long id);
	
	List<TicketDto> searchTicket(String query);

	List<TicketDto> searchTickets(String query);

	TicketDto viewTicket(Long id);

}
