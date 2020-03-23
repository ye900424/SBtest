package inject;

import com.model.Person;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author C.A.O
 * @date 2020/2/25
 */
public class TypeTest {
    public static void main(String[] args) {

        System.out.println(Person.class.getGenericInterfaces());

        Arrays.stream(Person.class.getDeclaredFields()).forEach(field -> {
            System.out.print(field.getType() + "   ");
            Type type =  field.getGenericType();
            System.out.println(type instanceof ParameterizedType);

        });

    }
}
