package in.simplygeek.show.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Actor {
	private long id;
    private String name;
    private Boolean isMale;
    private String wikiLink;
    private String filmCity;
	private String actorUniqueId;
}