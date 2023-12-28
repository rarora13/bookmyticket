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
import org.springframework.web.bind.annotation.RestController;

import in.simplygeek.theatre.entities.Audi;
import in.simplygeek.theatre.entities.Seat;
import in.simplygeek.theatre.service.AudiService;

@RestController
@RequestMapping("/audis")
public class AudiController {
    private final AudiService audiService;
    
    @Autowired
    public AudiController(AudiService audiService) {
        this.audiService = audiService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audi> getAudiById(@PathVariable Long id) {
        Audi audi = audiService.getAudiById(id);
        return ResponseEntity.ok().body(audi);
    }
    
    @GetMapping("/{id}/seats")
    public ResponseEntity<List<Seat>> getSeats(@PathVariable Long id) {
        Audi audi = audiService.getAudiById(id);
        return ResponseEntity.ok().body(audi.getSeats());
    }

    @PostMapping
    public ResponseEntity<Audi> createAudi(@RequestBody Audi audi) {
        Audi createdAudi = audiService.createAudi(audi);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAudi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Audi> updateAudi(@PathVariable Long id, @RequestBody Audi audi) {
        Audi updatedAudi = audiService.updateAudi(id, audi);
        return ResponseEntity.ok().body(updatedAudi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudi(@PathVariable Long id) {
        audiService.deleteAudi(id);
        return ResponseEntity.noContent().build();
    }
}
