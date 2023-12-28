package in.simplygeek.show.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.simplygeek.show.bean.TheatreSeat;
import in.simplygeek.show.entities.InventorySeat;
import in.simplygeek.show.repository.SeatRepository;
import jakarta.persistence.EntityNotFoundException;

@EnableDiscoveryClient
@Service
public class InventoryService {
    private final SeatRepository SeatRepository;
    private final RestTemplate restTemplate;
    
    @Autowired
    public InventoryService(SeatRepository SeatRepository, 
    		RestTemplate restTemplate) {
        this.SeatRepository = SeatRepository;
        this.restTemplate = restTemplate;
    }

	public List<InventorySeat> getSeats() {
		return SeatRepository.findAll();
	}
    
    public InventorySeat getSeatById(Long id) {
		return SeatRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Seat not found with id :"+id));
	}

	public InventorySeat createSeat(InventorySeat Seat) {
		return SeatRepository.save(Seat);
	}

	public InventorySeat updateSeat(Long id, InventorySeat Seat) {
		InventorySeat existingSeat = SeatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + id));

        // Update the existing Seat's properties
		existingSeat.setStatus(Seat.getStatus());
		existingSeat.setTicketId(Seat.getTicketId());
        

        // Save the updated Seat
        return SeatRepository.save(existingSeat);
	}

	public void deleteSeat(Long id) {
		// Check if the Seat with the given id exists in the database
        InventorySeat existingSeat = SeatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + id));

        // Delete the Seat
        SeatRepository.delete(existingSeat);
	}
	
	public List<TheatreSeat> getSeatsForShow(long audiId) {
        // Fetching Theatre service URL using Eureka
        String theatreServiceName = "theatre-service"; // Replace with your registered service name in Eureka
        String theatreServiceUrl = 	"http://"+theatreServiceName;//discoveryClient.getInstances(theatreServiceName).get(0).getUri().toString();

        String seatsEndpoint = theatreServiceUrl +  "/audis/" + audiId + "/seats";

        TheatreSeat[] seats = restTemplate.getForObject(seatsEndpoint, TheatreSeat[].class);
		return Arrays.asList(seats);
    }
}
