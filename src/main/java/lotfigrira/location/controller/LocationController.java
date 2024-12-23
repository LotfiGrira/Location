package lotfigrira.location.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lotfigrira.location.modul.Adherant;
import lotfigrira.location.modul.Reservation;
import lotfigrira.location.modul.Terrain;
import lotfigrira.location.services.AdherantService;
import lotfigrira.location.services.ReservationService;
import lotfigrira.location.services.TerrainService;

@RestController
public class LocationController extends Exception{

        private ReservationService reservationService;
        @Autowired
        LocationController (ReservationService reservationService){
            this.reservationService=reservationService;
            
    }


@PostMapping("/new-reservation")
    public ResponseEntity<String> saveReservation(@RequestBody Reservation reservation) {
        try {
            reservationService.saveReservation(reservation);
            return ResponseEntity.ok("Reservation saved successfully!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save reservation"+ e.getMessage());
        }
    }
@GetMapping("/reservations")
    public List<Reservation> findAllReservation(){
        return reservationService.findAllReservation();
    }

@DeleteMapping("/remove-reservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID should not be null !!!!");
        }
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully!");
        } catch (Exception e) {
            return    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                    .body("Failed to delete reservation. Reason: " + e.getMessage());
        }
    }

@GetMapping("/reservation/{id}")
    public Reservation findReservationById(@PathVariable Integer id){
        
        return reservationService.findReservationById(id);
    }

    @GetMapping("/available-hours")
    public ResponseEntity<List<Integer>> getAvailableHoursForTerrain(
        @RequestParam Integer terrainId,
        @RequestParam String dateRes
    ) {
        List<Integer> availableHours = reservationService.getAvailableHoursForTerrain(terrainId, dateRes);

        return ResponseEntity.ok(availableHours);
    }

}