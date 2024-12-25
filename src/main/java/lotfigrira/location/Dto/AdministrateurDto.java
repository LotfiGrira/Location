package lotfigrira.location.Dto;

import lombok.Builder;
import lombok.Data;
import lotfigrira.location.modul.Administrateur;

@Builder
@Data
public class AdministrateurDto {
    private Integer id ;
    private String nom; 
    private String userName; 
    private String password; 

    public static AdministrateurDto toDto(Administrateur admin){
        if (admin == null) {
            return null ;            
        }
        return AdministrateurDto.builder()
        .id(admin.getId())
        .nom(admin.getNom())
        .userName(admin.getUserName())
        .password(admin.getPassword())
        .build();
    }
    public static Administrateur toEntity(AdministrateurDto dto){
        if (dto == null) {
            return null ;
        }
        Administrateur admin =new Administrateur();
        admin.setId(dto.getId());
        admin.setNom(dto.getNom());
        admin.setUserName(dto.getUserName());
        admin.setPassword(dto.getPassword());
        return admin ;
    }

}
