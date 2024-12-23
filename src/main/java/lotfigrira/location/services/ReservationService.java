package lotfigrira.location.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lotfigrira.location.modul.Reservation;
import lotfigrira.location.repo.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation or reservation date cannot be NULL !!!");
        }
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                reservation.getDate_res(),
                reservation.getHeure_debut(),
                reservation.getHeure_fin()
        );
        if (!overlappingReservations.isEmpty()) {
            throw new IllegalStateException("The reservation overlaps with an existing reservation !!!");
        }
        return reservationRepository.save(reservation);
    }
    
    public Reservation findReservationById(Integer id){
        if (id == null) {
            throw new RuntimeException("ID should not be NULL !!!");
        }

        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation with this ID: "+id+" Not found !!!"));
    }

    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Transactional
    public void deleteReservation(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID should not be NULL!");
        }
        try {
            if (reservationRepository.existsById(id)) {
                reservationRepository.deleteById(id);
            } else {
                throw new IllegalStateException("No object exists with this ID: " + id);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error reservation with ID: " + id + ". Reason: " + e.getMessage(), e);
        }
    }

    public List<Integer> getAvailableHoursForTerrain(Integer terrainId, String dateRes) {
        int openingHour = 8;
        int closingHour = 20;

        List<Integer> availableHours = new ArrayList<>();

        for (int hour = openingHour; hour < closingHour; hour++) {
            int heureDebut = hour;
            int heureFin = hour + 1;

            List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                dateRes, heureDebut, heureFin);

            boolean isTerrainOverlapping = overlappingReservations.stream()
                .anyMatch(reservation -> reservation.getTerrain().getId().equals(terrainId));

            if (!isTerrainOverlapping) {
                availableHours.add(hour);
            }
        }
    
        return availableHours;
    }
    
}
