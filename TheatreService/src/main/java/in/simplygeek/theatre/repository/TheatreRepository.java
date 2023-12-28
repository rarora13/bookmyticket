package in.simplygeek.theatre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.simplygeek.theatre.entities.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    
	@Query("SELECT t FROM Theatre t JOIN t.address a JOIN a.city c WHERE c.name = :cityName")
    public List<Theatre> findTheatresByCityName(@Param("cityName") String cityName);
}
