package in.simplygeek.theatre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.theatre.entities.Audi;
import in.simplygeek.theatre.repository.AudiRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AudiService {
    private final AudiRepository audiRepository;

    @Autowired
	public AudiService(AudiRepository audiRepository) {
		this.audiRepository = audiRepository;
	}

	public Audi getAudiById(Long id) {
		return audiRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Audi not found with id :"+id));
	}

	public Audi createAudi(Audi audi) {
		return audiRepository.save(audi);
	}

	public Audi updateAudi(Long id, Audi audi) {
		Audi existingAudi = audiRepository.findById(id).
		orElseThrow(()-> new EntityNotFoundException("Audi not found with id :"+id));
		
		existingAudi.setName(audi.getName());
		existingAudi.setStatus(audi.getStatus());
		
		return audiRepository.save(existingAudi);
	}

	public void deleteAudi(Long id) {
		Audi existingAudi = audiRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Audi not found with id :"+id));
		
		audiRepository.delete(existingAudi);
		
	}
}
