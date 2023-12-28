package in.simplygeek.show.entities;



import java.util.Date;
import java.util.List;
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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="movie_show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Long movieId;
    
    @Column
    private Long audiId;
    
    @Column
    private Date startTime;
    
    @Column
    private Date endTime;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<InventorySeat> inventory;
    
    @Column
    private Boolean status;
    
    @Column
	private String showUniqueId = UUID.randomUUID().toString();
    
}
