package in.simplygeek.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.show.entities.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    // Custom queries if needed
}
