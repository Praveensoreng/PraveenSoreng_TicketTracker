package com.session.ticket.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="Ticket")
public class Ticket {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="Ticket Title")
	private String ticketTitle;
	
	@Column(name="Ticket Short Description")
	private String ticketDescription;
	
    @Lob
	@Column(name= "Content")
	private String content;
	
	@CreationTimestamp
	@Column(name="Ticket Created On")
	private LocalDateTime  createdOn;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;	
	
}
