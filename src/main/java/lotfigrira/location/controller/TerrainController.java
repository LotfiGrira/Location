package lotfigrira.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import lotfigrira.location.modul.Terrain;
import lotfigrira.location.services.TerrainService;

@RestController
public class TerrainController {
    private TerrainService terrainService;
    @Autowired
    TerrainController (TerrainService terrainService){
        this.terrainService=terrainService;
    }

@PostMapping("/new-terrain")
    public ResponseEntity<String> saveTerrain(Terrain terrain) {
        
        try {
            terrainService.saveTerrain(terrain);
            return ResponseEntity.ok("save terrain successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete adherant. Reason: " + e.getMessage());
        }
    }

@GetMapping("/terrain/{id}")
    public Terrain findTerrainById(@PathVariable Integer id){
        return terrainService.findTerrainById(id);
}

@DeleteMapping("/remove-terrain/{id}")
    public String deleteTerrain(@PathVariable Integer id){
        terrainService.deleteTerrain(id);
        return "terrain deleted succesfully" + id;
    }

}
