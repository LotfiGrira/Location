package lotfigrira.location.Dto;

import lombok.Builder;
import lombok.Data;
import lotfigrira.location.modul.Terrain;

@Builder
@Data
public class TerrainDto {
    
    private Integer id; 
    private String nom; 
    private String surface;

    public static TerrainDto fromEntity(Terrain terrain){
        if (terrain==null) {
            return null ;                
        }
        return TerrainDto.builder()
        .id(terrain.getId())
        .nom(terrain.getNom())
        .surface(terrain.getSurface())
        .build();
    }
    public static Terrain toEntity(TerrainDto terrainDto){
        if (terrainDto==null) {
            return null ;
        }
        Terrain terrain= new Terrain();
        terrain.setId(terrainDto.getId());
        terrain.setNom(terrainDto.getNom());
        terrain.setSurface(terrainDto.getSurface());
        return terrain;
    }
}
