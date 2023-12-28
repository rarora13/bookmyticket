package in.simplygeek.show.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import in.simplygeek.show.bean.Theatre;
import in.simplygeek.show.bean.TheatreSeat;

public interface TheatreService {

	@GetExchange("/audis/{audiId}/seats")
	List<TheatreSeat> getAudiSeats(@PathVariable Long audiId);
	
	@GetExchange("/theatres")
	List<Theatre> getTheatresByCity(@RequestParam String cityName);

}