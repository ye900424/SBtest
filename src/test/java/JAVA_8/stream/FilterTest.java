package JAVA_8.stream;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/12/10
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,1,1,1);


        System.out.print(list.stream().anyMatch(integer -> integer == 2));
    }
}
