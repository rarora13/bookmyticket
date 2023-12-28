package in.simplygeek.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.movie.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Custom queries if needed
}
