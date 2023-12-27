package in.simplygeek.show.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
//        // Fetching Theatre service URL using Eureka
//        String theatreServiceName = "theatre-service"; // Replace with your registered service name in Eureka
//        //theatreServiceName = "localhost:8080";
//        String theatreServiceUrl = 	"http://"+theatreServiceName;//discoveryClient.getInstances(theatreServiceName).get(0).getUri().toString();
//
//        String seatsEndpoint = theatreServiceUrl +  "/audis/" + audiId + "/seats";
//
//        TheatreSeat[] seats = restTemplate.getForObject(seatsEndpoint, TheatreSeat[].class);
		String json = "[{\"seatId\":1,\"seatNumber\":\"1\",\"row\":\"A\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"b8b059c4-ed78-4ed6-b8a9-fd4e74e9c110\"},{\"seatId\":2,\"seatNumber\":\"2\",\"row\":\"A\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"25865586-f6a1-40ae-8f85-58bd309c3068\"},{\"seatId\":3,\"seatNumber\":\"3\",\"row\":\"A\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"28a80cb5-264b-4a45-b4f4-2bd04fda36b8\"},{\"seatId\":4,\"seatNumber\":\"4\",\"row\":\"A\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"8f14d64d-42ac-4f52-b9fd-2ab2fb55d40d\"},{\"seatId\":5,\"seatNumber\":\"1\",\"row\":\"B\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"0b4c6a1b-e607-4fd9-bd48-f1ef5e064320\"},{\"seatId\":6,\"seatNumber\":\"2\",\"row\":\"B\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"93b9d8bd-b61d-4dac-bf43-9d610dff9ff8\"},{\"seatId\":7,\"seatNumber\":\"3\",\"row\":\"B\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"4806c53a-e481-4d86-8aca-00d418b12bd6\"},{\"seatId\":8,\"seatNumber\":\"4\",\"row\":\"B\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"6d3f4609-e81c-4d60-863a-3310ce971432\"},{\"seatId\":9,\"seatNumber\":\"1\",\"row\":\"C\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"ecb020ea-47b7-4458-a123-d4b8916c6b65\"},{\"seatId\":10,\"seatNumber\":\"2\",\"row\":\"C\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"3272d0fe-65a9-466f-b1e0-dee141ec11db\"},{\"seatId\":11,\"seatNumber\":\"3\",\"row\":\"C\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"0fba2bc9-fd74-4851-8f34-49718d992050\"},{\"seatId\":12,\"seatNumber\":\"4\",\"row\":\"C\",\"status\":\"true\",\"type\":\"gold\",\"price\":null,\"seatUniqueId\":\"cb36a206-36c9-449a-817c-c2252697d80a\"}]";
		try {
		ObjectMapper mapper = new ObjectMapper();
		List<TheatreSeat> seats = mapper.readValue(json, new TypeReference<List<TheatreSeat>>() {});
        return seats;
		}catch (Exception e) {
			System.out.println("Exception e"+e);
		}
		return new ArrayList<TheatreSeat>();
    }
}
