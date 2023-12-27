package in.simplygeek.show.entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "inventory")
public class InventorySeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String seatNumber;
	
	@Column(name = "row_no")
	private String row;
	
	@Column
	private Boolean status;
	
	@Column
	private Long ticketId;
	
	@Column
	private String type;
	
	@Column
	private BigDecimal price;
	
	@Column
	private Long seatId;
	
	
	@Column
	private String inventoryUniqueId = UUID.randomUUID().toString();
}