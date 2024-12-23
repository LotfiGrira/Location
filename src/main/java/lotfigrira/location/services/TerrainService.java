package lotfigrira.location.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import lotfigrira.location.modul.Terrain;
import lotfigrira.location.repo.TerrainRepository;

@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;
    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public Terrain saveTerrain(Terrain terrain) {
        if (ObjectUtils.isEmpty(terrain)) {
            throw new IllegalArgumentException("The terrain object cannot be NULL !!!");
        }
        return terrainRepository.save(terrain);
    }


    public Terrain findTerrainById(Integer id){
        if (id == null) {
            throw new RuntimeException("ID should not be NULL !!");
        }
        return terrainRepository.findById(id).orElseThrow(()-> new RuntimeException("No exist 'Terrain' with this ID :" + id + " !!!!"));
    }

    public List<Terrain> findAllTerrains() {
        return terrainRepository.findAll();
    }

    public void deleteTerrain(Integer id){
        if (id == null) {
            throw new RuntimeException("ID should not be NULL !!!");
        }
        try {
            terrainRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Can't delete this object with that ID: "+ id);
        }
    }
}
