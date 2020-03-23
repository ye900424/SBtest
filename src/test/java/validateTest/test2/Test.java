package validateTest.test2;

import java.util.Map;

/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/11/8
 */
public class Test {
    @org.junit.Test
    public void testValidation() {
        Person person = new Person();
        person.setAge(12);
        person.setGender(2);
        person.setName("李智龙");
        ValidationResult result = ValidationUtils.validateEntity(person);
//        ValidationResult result = ValidationUtils.validateEntityByGroup(person,Inte2.class);
        Map<String, String> map = result.getErrorMsg();
        boolean isError = result.isHasErrors();
        System.out.println("isError: " + isError);
        System.out.println(map);


    }


}
