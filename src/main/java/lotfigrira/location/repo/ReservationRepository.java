package lotfigrira.location.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lotfigrira.location.modul.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
    @Query("SELECT r FROM Reservation r " +
    "WHERE r.date_res = :dateRes " +
    "AND (" +
    "(:heureDebut >= r.heure_debut AND :heureDebut < r.heure_fin) OR " +
    "(:heureFin > r.heure_debut AND :heureFin <= r.heure_fin) OR " +
    "(:heureDebut <= r.heure_debut AND :heureFin >= r.heure_fin) OR" +
    "(:heureDebut >= r.heure_debut AND :heureFin <= r.heure_fin)" +
    ")")
    List<Reservation> findOverlappingReservations(
    @Param("dateRes") String dateRes,
    @Param("heureDebut") int heureDebut,
    @Param("heureFin") int heureFin
    );
}
