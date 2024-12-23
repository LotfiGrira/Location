package lotfigrira.location.modul;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id; 
    private String date_res; 
    private int heure_debut; 
    private int heure_fin; 
    @ManyToOne 
    private Adherant user;
    @ManyToOne 
    private Terrain terrain;
}
