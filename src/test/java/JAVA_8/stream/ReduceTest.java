package JAVA_8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by C.A.O on 2018/6/11.
 */
public class ReduceTest {
    public static void main(String[] args) {
        ReduceTest.fun();
    }

    public static String fun(){
        Stream<Integer> stream = Stream.of(1,2,3,4);

        Optional add = Stream.of(1,2,3,4).reduce(Integer::sum);
        System.out.println("add:" + add.get());

        Optional max = Stream.of(1,2,3,4).reduce((x,y) -> {
            if(x > y){
                return x;
            }else{
                return y;
            }
        });
        System.out.println("max:" + max.get());

        //构造字符串流
        List<String> strs = Arrays.asList("H", "E", "L", "L", "O");

        // reduce
        String concatReduce = strs.stream().reduce("", String::concat);
        System.out.println("concat:"+concatReduce);


        return "";
    }
}
