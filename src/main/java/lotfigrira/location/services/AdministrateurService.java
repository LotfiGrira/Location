package lotfigrira.location.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import lotfigrira.location.Dto.AdministrateurDto;
import lotfigrira.location.Validators.AdminValidator;
import lotfigrira.location.exceptions.EntityNotFoundException;
import lotfigrira.location.exceptions.InvalidEntityException;
import lotfigrira.location.repo.AdministrateurRepository;

@Service
@Slf4j
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;
    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public AdministrateurDto save(AdministrateurDto dto) {
        List<String> errors =AdminValidator.validate(dto);
        if (errors.isEmpty()) {
            throw new InvalidEntityException("The administrateur object cannot be NULL !!!",errors);
        }
        return AdministrateurDto.toDto(administrateurRepository.save(AdministrateurDto.toEntity(dto)));
    }

    public AdministrateurDto findById(Integer id){
        if (id == null) {
            log.error("ID should not be null !");
            return null ;
        }
        return administrateurRepository
                .findById(id)
                .map(AdministrateurDto::toDto)
                .orElseThrow(()->new EntityNotFoundException("Can't find object with this ID"+ id + " !!!"));
    }

    public List<AdministrateurDto> findAll(){
        return  administrateurRepository
        .findAll()
        .stream()
        .map(AdministrateurDto::toDto)
        .collect(Collectors.toList());

    }
    public String delete (Integer id) {
        if (id == null) {
            log.error("ID is null !");
            throw new RuntimeException("ID is NULLL !");
        }
        administrateurRepository.deleteById(id);
        return "deleted successfully item with ID :" + id;
    }
}
