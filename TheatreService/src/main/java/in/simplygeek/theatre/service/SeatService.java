package in.simplygeek.theatre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.theatre.entities.Seat;
import in.simplygeek.theatre.repository.SeatRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    
    @Autowired
    public SeatService(SeatRepository seatRepository) {
    	this.seatRepository = seatRepository;
    }

	public Seat getSeatById(Long id) {
		return seatRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Seat not found with id :"+id));
	}

	public Seat createSeat(Seat seat) {
		return seatRepository.save(seat);
	}

	public Seat updateSeat(Long id, Seat seat) {
		Seat existingSeat = seatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + id));

        // Update the existing seat's properties
		//BeanUtils.copyProperties(seat, existingTheater);
		existingSeat.setPrice(seat.getPrice());
		existingSeat.setSeatNumber(seat.getSeatNumber());
		existingSeat.setRow(seat.getRow());
		existingSeat.setType(seat.getType());
		existingSeat.setStatus(seat.getStatus());
        

        // Save the updated seat
        return seatRepository.save(existingSeat);
	}

	public void deleteSeat(Long id) {
		Seat existingSeat = seatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + id));

        // Delete the seat
        seatRepository.delete(existingSeat);
		
	}
}
