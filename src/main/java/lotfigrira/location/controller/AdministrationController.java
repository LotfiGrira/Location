package lotfigrira.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import lotfigrira.location.Dto.AdministrateurDto;
import lotfigrira.location.services.AdministrateurService;

@RestController
public class AdministrationController {
    private AdministrateurService adminService ;
    @Autowired
    public AdministrationController (
        AdministrateurService adminService
    ){
        this.adminService=adminService;
    }

@PostMapping("/new-admin")
    public AdministrateurDto save(AdministrateurDto dto){
        return adminService.save(dto);
    }

@GetMapping("/admin/{id}")
    public AdministrateurDto findById(@PathVariable Integer id){
        return adminService.findById(id);
    }

@GetMapping("/admins")
    public List<AdministrateurDto> findAll(){
        return adminService.findAll();
    }

@DeleteMapping("/remove-admin/{id}")
    public String delete(@PathVariable Integer id){
        return adminService.delete(id);
    }
}
