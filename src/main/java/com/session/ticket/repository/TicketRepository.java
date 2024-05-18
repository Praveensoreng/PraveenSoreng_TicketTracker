package com.session.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.session.ticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	
	@Query("SELECT p from Ticket p WHERE " +
            " p.ticketTitle LIKE CONCAT('%', :query, '%') OR " +
            " p.ticketDescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);
	
	
}
