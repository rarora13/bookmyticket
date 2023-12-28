package in.simplygeek.show.bean;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Theatre {
	private Long id;
    private String name;
    private Set<TheatreAudi> audis;
    private String googleLocaltionLink;
    private Boolean status;
	private String theatreUniqueId;
}