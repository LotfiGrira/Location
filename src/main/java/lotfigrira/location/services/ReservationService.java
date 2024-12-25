package lotfigrira.location.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import lotfigrira.location.Dto.ReservationDto;
import lotfigrira.location.Validators.ReservationValidator;
import lotfigrira.location.exceptions.InvalidEntityException;
import lotfigrira.location.modul.Reservation;
import lotfigrira.location.repo.ReservationRepository;

@Service
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto save(ReservationDto dto) {
        List<String> errors=ReservationValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Invalid reservation {}", dto);
            throw new InvalidEntityException("invalid reservation",errors);
        }
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                dto.getDate_res(),
                dto.getHeure_debut(),
                dto.getHeure_fin()
        );
        if (!overlappingReservations.isEmpty()) {
            throw new IllegalStateException("The reservation overlaps with an existing reservation !!!");
        }
        return  ReservationDto.fromEntity(reservationRepository.save(ReservationDto.toEntity(dto))) ;
    }
    
    public ReservationDto findById(Integer id){
        if (id == null) {
            log.error("ID should not be NULL !");
            return null ;
        }

    return reservationRepository.findById(id).map(ReservationDto::fromEntity).orElseThrow(()-> 
        new EntityNotFoundException(
        "none adherant with this ID : "+ id +" found"));
    }

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll().stream()
        .map(ReservationDto::fromEntity)
        .collect(Collectors.toList())
        ;
    }

    public String delete(Integer id){
        if (id == null) {
            log.error("ID is NULL !");
            return "ID is null !!";
        }
        reservationRepository.deleteById(id);
        return "deleted successfully";
    }
    // public List<Integer> getAvailableHoursForTerrain(Integer terrainId, String dateRes) {
    //     int openingHour = 8;
    //     int closingHour = 20;

    //     List<Integer> availableHours = new ArrayList<>();

    //     for (int hour = openingHour; hour < closingHour; hour++) {
    //         int heureDebut = hour;
    //         int heureFin = hour + 1;

    //         List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
    //             dateRes, heureDebut, heureFin);

    //         boolean isTerrainOverlapping = overlappingReservations.stream()
    //             .anyMatch(reservation -> reservation.getTerrain().getId().equals(terrainId));

    //         if (!isTerrainOverlapping) {
    //             availableHours.add(hour);
    //         }
    //     }
    
    //     return availableHours;
    // }
    
}
