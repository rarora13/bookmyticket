package in.simplygeek.theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.simplygeek.theatre.entities.Theatre;
import in.simplygeek.theatre.service.TheatreService;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreService theaterService;
    
    @Autowired
    public TheatreController(TheatreService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Theatre>> getTheatres() {
        List<Theatre> theaters = theaterService.getTheatres();
        return ResponseEntity.ok().body(theaters);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable Long id) {
        Theatre theater = theaterService.getTheatreById(id);
        return ResponseEntity.ok().body(theater);
    }
    
    @GetMapping
    public ResponseEntity<List<Theatre>> getTheatresByCityName(@RequestParam String cityName) {
        List<Theatre> theatres = theaterService.getTheatresByCityName(cityName);
        return ResponseEntity.ok().body(theatres);
    }

    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theater) {
        Theatre createdTheatre = theaterService.createTheatre(theater);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheatre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable Long id, @RequestBody Theatre theater) {
        Theatre updatedTheatre = theaterService.updateTheatre(id, theater);
        return ResponseEntity.ok().body(updatedTheatre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable Long id) {
        theaterService.deleteTheatre(id);
        return ResponseEntity.noContent().build();
    }
}
