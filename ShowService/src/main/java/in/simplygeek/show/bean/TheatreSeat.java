package in.simplygeek.show.bean;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TheatreSeat {
	private String seatNumber;
	private String row;
	private Boolean status;
	private Long ticketId;
	private String type;
	private BigDecimal price;
	private String seatUniqueId;
	private String seatId;
}