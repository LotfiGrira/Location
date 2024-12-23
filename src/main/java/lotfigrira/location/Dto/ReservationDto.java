package lotfigrira.location.Dto;

import lombok.Builder;
import lombok.Data;
import lotfigrira.location.modul.Reservation;

@Builder
@Data
public class ReservationDto {
    
    private Integer id; 
    private String date_res; 
    private int heure_debut; 
    private int heure_fin; 
    private AdherantDto user;
    private TerrainDto terrain;

    public static ReservationDto fromEntity(Reservation reservation){
        if (reservation==null) {
            return null ;
        }
        return ReservationDto.builder()
                .id(reservation.getId())
                .date_res(reservation.getDate_res())
                .heure_debut(reservation.getHeure_debut())
                .heure_fin(reservation.getHeure_fin())
                .user(AdherantDto.fromEntity(reservation.getUser()))
                .terrain(TerrainDto.fromEntity(reservation.getTerrain()))
                .build();

            }
    public static Reservation toEntity(ReservationDto reservationDto){
        if (reservationDto==null) {
            return null ;
        }
        Reservation reservation=new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setDate_res(reservationDto.getDate_res());
        reservation.setHeure_debut(reservationDto.getHeure_debut());
        reservation.setHeure_fin(reservationDto.getHeure_fin());
        reservation.setUser(AdherantDto.toEntity(reservationDto.getUser()));
        reservation.setTerrain(TerrainDto.toEntity(reservationDto.getTerrain()));
        
        return reservation ;
    }
            
}
