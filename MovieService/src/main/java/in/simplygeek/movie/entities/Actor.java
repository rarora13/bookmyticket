package in.simplygeek.movie.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
    private String name;
    
    @Column
    private Boolean isMale;
    
    @Column
    private String wikiLink;
    
    @Column
    private String filmCity;
    
    @Column
	private String actorUniqueId = UUID.randomUUID().toString();
}