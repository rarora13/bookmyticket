package in.simplygeek.theatre.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String status;
	
	@Column
	private String userId;

	@Column
	private String rating;
	
	@Column
	private String bookingId;
	
	private String comments;
	
	@Column
	private String reviewUniqueId = UUID.randomUUID().toString();
}