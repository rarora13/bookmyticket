package in.simplygeek.show.bean;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Movie {
	private Long id;
    private String title;
    private String description;
    private String youtubeTrailerLink;
    private Boolean status;
    private String sensorBoardRating;
    private Set<Actor> actors;
    private Set<Rating> ratings;
	private String movieUniqueId;
}