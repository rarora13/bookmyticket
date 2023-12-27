package in.simplygeek.show.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.simplygeek.show.bean.ShowRequest;
import in.simplygeek.show.bean.TheatreSeat;
import in.simplygeek.show.entities.InventorySeat;
import in.simplygeek.show.entities.Show;
import in.simplygeek.show.repository.ShowRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ShowService {
    private final ShowRepository ShowRepository;
    private final InventoryService inventoryService;
    
    @Autowired
    public ShowService(ShowRepository ShowRepository,
    		InventoryService inventoryService) {
        this.ShowRepository = ShowRepository;
        this.inventoryService = inventoryService;
    }

	public List<Show> getShows() {
		return ShowRepository.findAll();
	}
    
    public Show getShowById(Long id) {
		return ShowRepository.findById(id).
				orElseThrow(()-> new EntityNotFoundException("Show not found with id :"+id));
	}

	public Show createShow(ShowRequest show) {
		Show showEntity = new Show();
		List<TheatreSeat> seats = inventoryService.getSeatsForShow(show.getAudiId());
		showEntity.setInventory(seats.stream().map((s)-> {
			// Map TheatreSeat attributes to InventorySeat
            InventorySeat inventorySeat = new InventorySeat();
            BeanUtils.copyProperties(s, inventorySeat);
//            inventorySeat.setSeatId(inventorySeat.getId());
//            inventorySeat.setId(0l);
            inventorySeat.setPrice(show.getPrice());
            return inventorySeat;
		}).collect(Collectors.toList()));
		showEntity.setAudiId(show.getAudiId());
		showEntity.setMovieId(show.getMovieId());
		showEntity.setStartTime(show.getStartTime());
		showEntity.setEndTime(show.getEndTime());
		showEntity.setStatus(show.isStatus());

		return ShowRepository.save(showEntity);
	}

	public Show updateShow(Long id, Show Show) {
		Show existingShow = ShowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Show not found with id: " + id));

        // Update the existing Show's properties
		existingShow.setStatus(Show.getStatus());
		existingShow.setStartTime(Show.getStartTime());
		existingShow.setEndTime(Show.getEndTime());
        

        // Save the updated Show
        return ShowRepository.save(existingShow);
	}

	public void deleteShow(Long id) {
		// Check if the Show with the given id exists in the database
        Show existingShow = ShowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Show not found with id: " + id));

        // Delete the Show
        ShowRepository.delete(existingShow);
	}
}
