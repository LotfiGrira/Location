package lotfigrira.location.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lotfigrira.location.Dto.ReservationDto;
import lotfigrira.location.services.ReservationService;

@RestController
public class LocationController extends Exception{

        private ReservationService reservationService;
        @Autowired
        LocationController (ReservationService reservationService){
            this.reservationService=reservationService;
            
    }


@PostMapping("/new-reservation")
    public ReservationDto save(@RequestBody ReservationDto dto) {
        return reservationService.save(dto);
    }
@GetMapping("/reservations")
    public List<ReservationDto> findAll(){
        return reservationService.findAll();
    }

@DeleteMapping("/remove-reservation/{id}")
    public String delete(@PathVariable Integer id) {
        return reservationService.delete(id);
    }

@GetMapping("/reservation/{id}")
    public ReservationDto findById(@PathVariable Integer id){
        return reservationService.findById(id);
    }

}