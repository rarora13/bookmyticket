package in.simplygeek.theatre.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.theatre.entities.Theatre;
import in.simplygeek.theatre.repository.TheatreRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TheatreService {
    private final TheatreRepository theaterRepository;
    
    @Autowired
    public TheatreService(TheatreRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theatre> getTheatres() {
		return theaterRepository.findAll();
	}
    
    public Theatre getTheatreById(Long id) {
		return theaterRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Theatre not found with id :"+id));
	}

	public Theatre createTheatre(Theatre theater) {
		return theaterRepository.save(theater);
	}

	public Theatre updateTheatre(Long id, Theatre theater) {
		Theatre existingTheater = theaterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Theater not found with id: " + id));

        // Update the existing theater's properties
		//BeanUtils.copyProperties(theater, existingTheater);
		existingTheater.setName(theater.getName());
		BeanUtils.copyProperties(theater.getAddress(), existingTheater.getAddress());
		existingTheater.setGoogleLocaltionLink(theater.getGoogleLocaltionLink());
        

        // Save the updated theater
        return theaterRepository.save(existingTheater);
	}

	public void deleteTheatre(Long id) {
		// Check if the theater with the given id exists in the database
        Theatre existingTheater = theaterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Theater not found with id: " + id));

        // Delete the theater
        theaterRepository.delete(existingTheater);
	}
}
