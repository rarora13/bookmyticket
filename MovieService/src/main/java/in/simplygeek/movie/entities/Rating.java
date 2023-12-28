package in.simplygeek.movie.entities;

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
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String status;
	
	@Column
	private String type;

	@Column
	private Integer rating;
	
	@Column
	private String comments;
	
	@Column
	private String ratingUniqueId = UUID.randomUUID().toString();
}