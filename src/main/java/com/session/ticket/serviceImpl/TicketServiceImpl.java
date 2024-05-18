package com.session.ticket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.session.ticket.dto.TicketDto;
import com.session.ticket.mapper.TicketMapper;
import com.session.ticket.model.Ticket;
import com.session.ticket.repository.TicketRepository;
import com.session.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	TicketRepository ticketRepository;
    
	@Autowired
	TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public void createTicket(TicketDto ticketDto) {

		Ticket ticket = TicketMapper.mapToTicket(ticketDto);
		ticketRepository.save(ticket);

	}

	@Override
	public List<TicketDto> listAllTickets() {

		List<Ticket> tickets = ticketRepository.findAll();

		return tickets.stream().map((ticket) -> TicketMapper.mapToTicketDto(ticket)).collect(Collectors.toList());

	}

	@Override
	public TicketDto findTicketById(Long id) {
		Ticket ticket = ticketRepository.findById(id).get();
		return TicketMapper.mapToTicketDto(ticket);
		
	}

	@Override
	public void updateTicket(TicketDto ticketDto) {
		Ticket ticket = TicketMapper.mapToTicket(ticketDto);
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		
		ticketRepository.deleteById(id);
		
	}

	@Override
	public List<TicketDto> searchTicket(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketDto> searchTickets(String query) {
		
		List<Ticket> tickets = ticketRepository.searchTickets(query);
		return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
	}

	@Override
	public TicketDto viewTicket(Long id) {
		
		Ticket ticket = ticketRepository.findById(id).get();
		return TicketMapper.mapToTicketDto(ticket);
	}

}
