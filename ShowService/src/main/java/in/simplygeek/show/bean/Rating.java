package in.simplygeek.show.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Rating {
	private long id;
	private String status;
	private String type;
	private Integer rating;
	private String comments;
	private String ratingUniqueId;
}