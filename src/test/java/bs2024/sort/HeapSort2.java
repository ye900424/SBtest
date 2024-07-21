package bs2024.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSort2 {
    public static void main(String[] args) {
        HeapSort2 instance = new HeapSort2();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k =2;

        Map<Integer,Integer> map = new HashMap();
        for(Integer i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);

        for(Map.Entry<Integer,Integer> entrySet : map.entrySet()){
            int num = entrySet.getKey();
            int count = entrySet.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.remove();
                    queue.add(new int[]{num,count});
                }
            }else{
                queue.add(new int[]{num,count});
            }
        }

        for(int i = 0 ; i < k ; i++){
            System.out.println(queue.remove()[0]);
        }
    }


}
