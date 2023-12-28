package in.simplygeek.show.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TheatreAudi {
	private long id;
	private String name;
	private String status;
	private String audiUniqueId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long theatreId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String theatreName;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String googleLocationLink;
}