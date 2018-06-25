package JAVA_8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by C.A.O on 2018/6/11.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4);
        Stream<Integer> intStream = intList.stream();
    }
}
