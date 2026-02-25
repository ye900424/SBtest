import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test_S {
    public static void main(String[] args) {

        Test_S instance = new Test_S();
        System.out.println(JSON.toJSONString(instance.canFinish(2,new int[][]{{1,0}})));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites){
            int first = arr[0];
            int second = arr[1];

            indegree[first]++;
            if(map.containsKey(second)){
                map.get(second).add(first);
            }else{
                List<Integer> list = new ArrayList();
                list.add(first);
                map.put(second,list);
            }
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = numCourses;
        while(!queue.isEmpty() && count > 0){
            count --;
            List<Integer> list = map.get(queue.poll());
            for(Integer num : list){
                indegree[num]--;
                if(indegree[num] == 0){
                    queue.add(num);
                }
            }
        }

        return count == 0;
    }
}
