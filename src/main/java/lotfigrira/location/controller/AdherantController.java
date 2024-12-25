package lotfigrira.location.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lotfigrira.location.Dto.AdherantDto;
import lotfigrira.location.services.AdherantService;

@RestController
public class AdherantController {

    private AdherantService adherantService;
@Autowired
AdherantController(AdherantService adherantService){
    this.adherantService=adherantService;
}

@PostMapping("/new-adherant")
    public AdherantDto save(@RequestBody AdherantDto dto){
        return adherantService.save(dto);
    }
@GetMapping("/adherant/{id}")
    public AdherantDto findById(@PathVariable Integer id){
        return adherantService.findById(id);
    }

@GetMapping("/adherant/all")
public List<AdherantDto> findAll(){
    return adherantService.findAll();
}

@DeleteMapping("/remove-adherant/{id}")
    public void delete(@PathVariable Integer id){
        adherantService.delete(id);
    }
}
