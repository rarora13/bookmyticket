package in.simplygeek.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.theatre.entities.Audi;

@Repository
public interface AudiRepository extends JpaRepository<Audi, Long> {
    // Custom queries if needed
}
