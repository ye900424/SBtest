import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by C.A.O on 2018/6/20.
 */
public class TestSplit {
    public static void main(String[] args) {
        TestSplit instance= new TestSplit();
        int[] nums = new int[]{100};
        List<String> list = new ArrayList();
        list.add("apple");
        list.add("pen");
        list.add("nice");
        int ret = instance.hIndex(nums);
        System.out.println(ret);
    }

    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        Map<Integer,Integer> map = new HashMap();
        for(int i = citations.length - 1; i >= 0 ;i--){
            int el = citations[i];

            if(i == citations.length - 1){
                map.put(el,1);
                continue;
            }

            if(map.containsKey(el)){
                map.put(el,map.get(el) + 1);
            }else{
                map.put(el,map.get(citations[i+1]) + 1);
            }
        }

        int ret = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= entry.getKey()){
                ret = Math.max(ret,entry.getKey());
            }
        }

        return ret;

    }
}
