package in.simplygeek.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.theatre.entities.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    // Custom queries if needed
}
