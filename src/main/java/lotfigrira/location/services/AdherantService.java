package lotfigrira.location.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import lotfigrira.location.Dto.AdherantDto;
import lotfigrira.location.Validators.AdherantValidator;
import lotfigrira.location.exceptions.InvalidEntityException;
import lotfigrira.location.repo.AdherantRepository;

@Service
@Slf4j
public class AdherantService {
    private final AdherantRepository adherantRepository;
    @Autowired
    public AdherantService(AdherantRepository adherantRepository) {
        this.adherantRepository = adherantRepository;
    }
    public AdherantDto save(AdherantDto dto){
        List<String> errors=AdherantValidator.validate(dto);
        if(!errors.isEmpty()){
                log.error("Invalid adherant {}", dto);
                throw new InvalidEntityException("invalid adherant",errors);
        }
        return AdherantDto.fromEntity(
                    adherantRepository.save(
                        AdherantDto.toEntity(dto)
                    )
                );
    }
    public AdherantDto findById(Integer id){
        if (id == null) {
            log.error("ID should not be NULL !");
            return null ;
        }
        return adherantRepository.findById(id).map(AdherantDto::fromEntity).orElseThrow(()-> 
            new EntityNotFoundException(
            "none adherant with this ID : "+ id +" found"));
    }
    
    public List<AdherantDto> findAll(){
        return adherantRepository.findAll().stream()
        .map(AdherantDto::fromEntity)
        .collect(Collectors.toList());
    }
    public void delete(Integer id){
        if (id == null) {
            log.error("ID is NULL !");
            return;
        }
        adherantRepository.deleteById(id);
    }

}
