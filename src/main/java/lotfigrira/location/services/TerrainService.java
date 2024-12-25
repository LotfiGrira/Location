package lotfigrira.location.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import lotfigrira.location.Dto.TerrainDto;
import lotfigrira.location.Validators.TerrainValidator;
import lotfigrira.location.exceptions.EntityNotFoundException;
import lotfigrira.location.exceptions.InvalidEntityException;
import lotfigrira.location.modul.Terrain;
import lotfigrira.location.repo.TerrainRepository;

@Service
@Slf4j
public class TerrainService {

    private final TerrainRepository terrainRepository;
    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public TerrainDto save(TerrainDto dto) {
        List<String> errors = TerrainValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Invalid type 'terrain'", errors);
            throw new InvalidEntityException("The object 'terrain' cannot be NULL !!!");
        }
        return TerrainDto.fromEntity(terrainRepository.save(TerrainDto.toEntity(dto)));
    }


    public TerrainDto findById(Integer id){
        if (id == null) {
            log.error("ID should not be NULL !!!");
            return null ;
        }
        return terrainRepository.findById(id).map(TerrainDto::fromEntity).orElseThrow(()-> 
                            new EntityNotFoundException(
                                "No exist 'Terrain' with this ID :" + id + " !!!!"
                                )
                                );
    }

    public List<TerrainDto> findAll() {
        return terrainRepository.findAll().stream()
                .map(TerrainDto::fromEntity)
                .collect(Collectors.toList())    
        ;
    }

    public String delete(Integer id){
        if (id == null) {
            log.error("ID shouled not be null !!!");
        }
            terrainRepository.deleteById(id);
            return "deteleted successfully !";
}

}