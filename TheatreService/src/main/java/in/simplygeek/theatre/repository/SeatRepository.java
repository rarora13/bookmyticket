package in.simplygeek.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.theatre.entities.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Custom queries if needed
}
