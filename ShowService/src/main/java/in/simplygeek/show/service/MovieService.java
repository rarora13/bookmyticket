package in.simplygeek.show.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import in.simplygeek.show.bean.Movie;

public interface MovieService {

	@GetExchange("/movies")
	List<Movie> getMovieByTitle(@RequestParam String title);

}