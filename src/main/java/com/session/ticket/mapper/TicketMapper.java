package com.session.ticket.mapper;

import com.session.ticket.dto.TicketDto;
import com.session.ticket.model.Ticket;

public class TicketMapper {

	
	//map to ticketDto
	public static TicketDto mapToTicketDto(Ticket ticket) {
		
		return TicketDto.builder()
		.id(ticket.getId())
		.ticketTitle(ticket.getTicketTitle())
		.ticketDescription(ticket.getTicketDescription())
		.content(ticket.getContent())
		.createdOn(ticket.getCreatedOn())
		.updatedOn(ticket.getUpdatedOn())
		.build();
	}
	
	//map to ticket
	public static Ticket mapToTicket(TicketDto ticketDto) {
		
		return Ticket.builder()
				.id(ticketDto.getId())
				.ticketTitle(ticketDto.getTicketTitle())
				.ticketDescription(ticketDto.getTicketDescription())
				.content(ticketDto.getContent())
				.createdOn(ticketDto.getCreatedOn())
				.updatedOn(ticketDto.getUpdatedOn())
				.build();
		}
}
