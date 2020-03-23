package validateTest.simpleTest;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by C.A.O on 2018/8/29.
 */
public class test {
    public static Validator validator ;
    public static ExecutableValidator executableValidator ;
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        config.messageInterpolator(new ParameterMessageInterpolator());

        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();

    }


    public static void main(String[] args) {

        City city = new City();
        city.setId("123456");

        Set<ConstraintViolation<Object>> result = validator.validate(city);
        for (Iterator<ConstraintViolation<Object>> it = result.iterator(); it.hasNext();) {
            ConstraintViolation<Object> violation = it.next();
            throw new RuntimeException(violation.getMessage());
        }
        System.out.println(result);

    }
}
