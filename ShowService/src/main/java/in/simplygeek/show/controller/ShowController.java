package in.simplygeek.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.simplygeek.show.bean.ShowRequest;
import in.simplygeek.show.entities.Show;
import in.simplygeek.show.service.ShowService;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;
    
    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Show>> getShows() {
        List<Show> shows = showService.getShows();
        return ResponseEntity.ok().body(shows);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShowById(id);
        return ResponseEntity.ok().body(show);
    }
    
    @GetMapping
    public ResponseEntity<List<Show>> getShowByMovieInCity(@RequestParam String cityName, 
    		@RequestParam String title) {
        List<Show> theatres = showService.getShow(title, cityName);
        return ResponseEntity.ok().body(theatres);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody ShowRequest show) {
        Show createdShow = showService.createShow(show);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShow);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = showService.updateShow(id, show);
        return ResponseEntity.ok().body(updatedShow);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }
}
