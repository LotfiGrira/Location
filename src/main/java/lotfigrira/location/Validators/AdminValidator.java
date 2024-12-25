package lotfigrira.location.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import lotfigrira.location.Dto.AdministrateurDto;

public class AdminValidator {

    public static List<String> validate (AdministrateurDto dto){
        List <String> errors =new ArrayList<>();
        if (dto == null) {
            errors.add("null");
            errors.add("null");
            errors.add("null");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Please fill the name field !");
        }
        if (!StringUtils.hasLength(dto.getUserName())) {
            errors.add("Please fill the username field !");
        }
        if (StringUtils.hasLength(dto.getPassword())) {
            errors.add("Please fill the password field !");
        }
        return errors;
    }

}
