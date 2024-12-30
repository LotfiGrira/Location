package lotfigrira.location.Validators;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import lotfigrira.location.Dto.ReservationDto;

public class ReservationValidator {
    public static List<String> validate(ReservationDto dto){
        List<String> errors =new ArrayList<>();
        
        if (dto == null) {
            errors.add("please fill the reservation date field !!!");
            errors.add("please fill the user fields !!!");
            errors.add("please fill the ground fields !!!");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getDate_res())) {
            errors.add("please fill the reservation date field !!!");
        }       
        if (dto.getUser()==null || dto.getUser().getId()==null) {
            errors.add("please fill the user fields !!!");
        }
        if (dto.getTerrain()==null || dto.getTerrain().getId()== null) {
            errors.add("please fill the ground fields !!!");     
        }
        return errors;
    }

}
