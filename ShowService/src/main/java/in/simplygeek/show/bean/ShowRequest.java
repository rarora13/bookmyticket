package in.simplygeek.show.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ShowRequest {
	private long movieId;
	private long audiId;
	private boolean status;
	private BigDecimal price;
	private Date startTime;
    private Date endTime;
}