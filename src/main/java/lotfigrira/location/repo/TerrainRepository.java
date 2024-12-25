package lotfigrira.location.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import lotfigrira.location.modul.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain,Integer> {
}
