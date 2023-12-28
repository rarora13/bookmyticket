package in.simplygeek.movie.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.movie.entities.Movie;
import in.simplygeek.movie.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}
    
    public Movie getMovieById(Long id) {
		return movieRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Movie not found with id :"+id));
	}

	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie updateMovie(Long id, Movie movie) {
		Movie existingmovie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("movie not found with id: " + id));

        // Update the existing movie's properties
		existingmovie.setTitle(movie.getTitle());
		existingmovie.setDescription(movie.getDescription());
		existingmovie.setYoutubeTrailerLink(movie.getYoutubeTrailerLink());
        

        // Save the updated movie
        return movieRepository.save(existingmovie);
	}

	public void deleteMovie(Long id) {
		// Check if the movie with the given id exists in the database
        Movie existingmovie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("movie not found with id: " + id));

        // Delete the movie
        movieRepository.delete(existingmovie);
	}
}
