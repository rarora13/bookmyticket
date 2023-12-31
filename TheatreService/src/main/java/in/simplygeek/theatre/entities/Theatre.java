package in.simplygeek.theatre.entities;



import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
 
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Address address;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private Set<Audi> audis;
    
    @Column
    private String googleLocaltionLink;
    
    @Column
    private Boolean status;
    
    @Column
	private String theatreUniqueId = UUID.randomUUID().toString();
    
}
