package in.simplygeek.movie.entities;



import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String description;
    
    @Column
    private String youtubeTrailerLink;
    
    @Column
    private Boolean status;
    
    @Column
    private String sensorBoardRating;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private Set<Actor> actors;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private Set<Rating> ratings;
    
    @Column
	private String movieUniqueId = UUID.randomUUID().toString();
    
}
