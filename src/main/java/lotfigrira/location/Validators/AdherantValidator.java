package lotfigrira.location.Validators;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.validation.Errors;

import lotfigrira.location.Dto.AdherantDto;

public class AdherantValidator {

    public static List<String> validate(AdherantDto dto){
        List<String> errors= new ArrayList<>();
        if(dto == null){
            errors.add("please fill the name field !!!");
            errors.add("please fill the email field !!!");
        }
        if(!org.springframework.util.StringUtils.hasLength(dto.getNom())){
            errors.add("please fill the name field !!!");
        }
        if(!org.springframework.util.StringUtils.hasLength(dto.getEmail())){
            errors.add("please fill the email field !!!");
        }
        return errors;
    }
}
