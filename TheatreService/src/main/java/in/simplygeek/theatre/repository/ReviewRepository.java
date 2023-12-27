package in.simplygeek.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.simplygeek.theatre.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom queries if needed
}
