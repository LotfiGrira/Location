package lotfigrira.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lotfigrira.location.Dto.AdherantDto;
import lotfigrira.location.modul.Adherant;
import lotfigrira.location.services.AdherantService;

@RestController
public class AdherantController {

    private AdherantService adherantService;
    @Autowired
    AdherantController(AdherantService adherantService){
        this.adherantService=adherantService;
    }

    @PostMapping("/new-adherant")
    public ResponseEntity<String> save(AdherantDto adherant){
        try {
            adherantService.save(adherant);
            return ResponseEntity.ok("Adherant saved successfully!");
        }
        catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save adherant"+ e.getMessage());
        }
    }
@GetMapping("/adherant/{id}")
    public Adherant findAdherantById(@PathVariable Integer id){
        return adherantService.findAdherantById(id);
    }

@DeleteMapping("/remove-adherant/{id}")
    public ResponseEntity<String> deleteAdherant(@PathVariable Integer id){
        try {
            adherantService.deleteAdherant(id);
            return ResponseEntity.ok("Adherant deleted successfully!");
        } catch (RuntimeException e) {
            return    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete adherant. Reason: " + e.getMessage());
        }
    }


}
