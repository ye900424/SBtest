package validateTest.test2;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/11/8
 */
public class Person {
    @Length(max = 20, message = "姓名长度不能大于20")
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Range(min = 0, max = 1, message = "性别只能输入只能输入0或1",groups = Inte2.class)
    private Integer gender;
    @Range(min = 0, max = 1, message = "年龄只能输入只能输入0或10",groups = Inte1.class)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
