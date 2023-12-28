package in.simplygeek.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.show.entities.InventorySeat;
import in.simplygeek.show.entities.Show;

@Repository
public interface SeatRepository extends JpaRepository<InventorySeat, Long> {
    // Custom queries if needed
}
