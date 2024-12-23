package lotfigrira.location.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lotfigrira.location.modul.Reservation;
import lotfigrira.location.modul.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain,Integer> {
}
