package JAVA_8.lambdaTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by caoyang on 2017/6/6.
 */
public class RefCalssMethod {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        List<String> strings = Lists.newArrayList("1","2","3","4","5","6","7");

        if(2==3){
                stringList = new ArrayList<>();
        }
        if(3==3){
            strings.forEach(s -> {
                stringList.add(s);
            });
        }

         List list = strings.stream().filter(s -> {
             if(s.equals("7")){
                 return false;
             }else{
                 return true;
             }
         }).collect(Collectors.toList());

        System.out.println(list.size());


        stringList.forEach(s -> System.out.println(s));


        List<String> parentCatalogCodes = Lists.newArrayList();
        System.out.println(parentCatalogCodes.contains("123"));
    }
}
