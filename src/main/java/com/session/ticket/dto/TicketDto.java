package com.session.ticket.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
	
	private Long id;
	
	private String ticketTitle;
	
	
	private String ticketDescription;
	
	
	private String content;
	
	
	private LocalDateTime  createdOn;
	
	
	private LocalDateTime updatedOn;	

}
