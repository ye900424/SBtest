package JAVA_8;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by caoyang on 2017/7/20.
 */
public class Test {
    public static void main(String[] args) {
        List<Parent> parents = Lists.newArrayList();

        Child child1 = new Child();
        child1.setId(1L);
        child1.setName("第一组第一个");
        child1.setGroupId(1L);
        Child child2 = new Child();
        child2.setId(2L);
        child2.setName("第一组第二个");
        child2.setGroupId(1L);

        parents.add(child1);
        parents.add(child2);

        System.out.println(parents.get(0).getId());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Parent{
    private Long id;
    private String name;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Child extends Parent{
    private Long groupId;

}