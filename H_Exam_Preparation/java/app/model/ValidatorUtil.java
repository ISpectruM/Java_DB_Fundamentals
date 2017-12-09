package app.model;


import app.model.entities.BasicCamera;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public final class ValidatorUtil {

    public static <E> boolean validate(E entity){
        Validator validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
        Set<ConstraintViolation<E>> constraintViolations =
                validator.validate(entity);

        return constraintViolations.size() == 0;
    }
}
