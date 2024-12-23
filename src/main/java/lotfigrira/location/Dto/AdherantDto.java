package lotfigrira.location.Dto;

import lombok.Builder;
import lombok.Data;
import lotfigrira.location.modul.Adherant;

@Builder
@Data
public class AdherantDto {
    
    private Integer id; 
    private String nom; 
    private String email; 
    
    public static AdherantDto fromEntity(Adherant adherant){
        if (adherant==null) {
            return null ;
        }

        return AdherantDto.builder()
                .id(adherant.getId())
                .nom(adherant.getNom())
                .email(adherant.getEmail())
                .build();
    }
    public static Adherant toEntity(AdherantDto adherantDto){
        if (adherantDto==null) {
            return null ;
        }
        Adherant adherant= new Adherant();
        adherant.setId(adherantDto.getId());
        adherant.setNom(adherantDto.getNom())
        adherant.setEmail(adherantDto.getEmail())
        
        return adherant;
    }
}
