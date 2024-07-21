package bs2024.pic;

import java.util.*;

public class _233_canFinish {
    public static void main(String[] args) {
        _233_canFinish instance = new _233_canFinish();
        int[][] prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(instance.canFinish(5,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数字，值代表进入i的前置个数
        int[] inDegree = new int[numCourses];
        // 邻接表
        Map<Integer,List<Integer>> map = new HashMap();

        for(int i = 0 ; i < prerequisites.length ; i ++){
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            // 入度统计 inDegree[first] = inDegree[first] + 1;
            inDegree[first] ++;

            // 节点顺序（课程顺序）记录，其实就是个邻接表
            if(map.containsKey(second)){
                map.get(second).add(first);
            }else{
                List<Integer> list = new ArrayList();
                list.add(first);
                map.put(second,list);
            }
        }

        // 将初度为0的加入队列
        Deque<Integer> deque = new ArrayDeque();
        for(int i = 0 ; i < inDegree.length ; i++){
            if(inDegree[i] == 0){
                deque.add(i);
            }
        }

        int ret = numCourses;
        // 操作队列（模拟上课）
        while(!deque.isEmpty()){
            ret -- ;
            int temp = deque.remove();
            List<Integer> list = map.get(temp);
            if(null != list && list.size() > 0){
                for(Integer i : list){
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        deque.add(i);
                    }
                }
            }
        }

        return ret == 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //定义入度数组，索引处（课程号）对应入度，比如课程0的入度为0
        int[] inDegree = new int[numCourses];
        //定义map数组，key课程号，value：依赖key的课程号，比如key为1，依赖的value为3，4
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length;i++){
            //遍历依赖关系表；在入度数组对应索引处++
            inDegree[prerequisites[i][0]]++;
            //没有对map初始化，这里对map初始化一个list数组，存放依赖的课程
            map.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            //在对应被依赖课程key处添加依赖key的课程
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //新建列表，把入度为0的课放进来
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i <inDegree.length;i++){
            if(inDegree[i]==0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            //弹出已选课程，在map找到依赖它的课程，在入度数组--
            int course = que.poll();
            numCourses--;
            for(int nextCourse : map.getOrDefault(course,new ArrayList<>())){
                if(--inDegree[nextCourse]==0){
                    que.offer(nextCourse);
                }
            }
        }
        return numCourses==0;
    }
}
