package lotfigrira.location.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import lotfigrira.location.Dto.TerrainDto;

public class TerrainValidator {

    public static List<String> validate(TerrainDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("please fill the name field !!!");
            errors.add("please fill the surface field !!!");
            return errors;
        }
        if (StringUtils.hasLength(dto.getNom())) {
            errors.add("please fill the name field !!!");
        }
        if (StringUtils.hasLength(dto.getSurface())) {
            errors.add("please fill the surface field !!!");
        }
        return errors;
    }
}
