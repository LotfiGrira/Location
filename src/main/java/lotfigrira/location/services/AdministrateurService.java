package lotfigrira.location.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lotfigrira.location.modul.Administrateur;
import lotfigrira.location.repo.AdministrateurRepository;

@Service
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;
    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public Administrateur saveAdministrateur(Administrateur administrateur) {
        if (ObjectUtils.isEmpty(administrateur)) {
            throw new IllegalArgumentException("The administrateur object cannot be NULL !!!");
        }
        return administrateurRepository.save(administrateur);
    }
}
