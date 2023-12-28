package in.simplygeek.show.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.simplygeek.show.entities.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	@Query("SELECT s FROM Show s WHERE s.movieId = :movieId AND s.audiId IN (:audiIds)")
	List<Show> findShow(@Param("movieId") Long movieId, @Param("audiIds") List<Long> audiIds);

}
