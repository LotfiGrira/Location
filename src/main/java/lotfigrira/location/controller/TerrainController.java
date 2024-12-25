package lotfigrira.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import lotfigrira.location.Dto.TerrainDto;
import lotfigrira.location.services.TerrainService;

@RestController
public class TerrainController {
    private TerrainService terrainService;
    @Autowired
    TerrainController (TerrainService terrainService){
        this.terrainService=terrainService;
    }

@PostMapping("/new-terrain")
    public TerrainDto save(TerrainDto dto) {
        return terrainService.save(dto);
    }

@GetMapping("/terrain/{id}")
    public TerrainDto findTerrainById(@PathVariable Integer id){
        return terrainService.findById(id);
}

@DeleteMapping("/remove-terrain/{id}")
    public String delete(@PathVariable Integer id){
        terrainService.delete(id);
        return "terrain deleted succesfully" + id;
    }
@GetMapping("/terrains")
public List<TerrainDto> findAll(){
    return terrainService.findAll();
}
}
