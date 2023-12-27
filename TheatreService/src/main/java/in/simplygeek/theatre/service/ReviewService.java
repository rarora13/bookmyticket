package in.simplygeek.theatre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.theatre.entities.Review;
import in.simplygeek.theatre.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    
    @Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public Review getReviewById(Long id) {
		return reviewRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Review not found with id :"+id));
	}

	public Review createReview(Review review) {
		return reviewRepository.save(review);
	}

	public Review updateReview(Long id, Review review) {
		Review existingReview = reviewRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Review not found with id :"+id));
		
		existingReview.setBookingId(review.getBookingId());
		existingReview.setComments(review.getComments());
		existingReview.setRating(review.getRating());
		existingReview.setStatus(review.getStatus());
		
		return reviewRepository.save(existingReview);
	}

	public void deleteReview(Long id) {
		Review existingReview = reviewRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Review not found with id :"+id));
		reviewRepository.delete(existingReview);
		
	}
}
