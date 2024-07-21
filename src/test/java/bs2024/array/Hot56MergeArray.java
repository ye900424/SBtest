package bs2024.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hot56MergeArray {

    public static void main(String[] args) {
        Hot56MergeArray instance = new Hot56MergeArray();
        System.out.println(instance.merge(new int[][]{{1,3},{8,10},{2,6},{15,18}}));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);

        List<int[]> list = new ArrayList();
        int[] temp = intervals[0];
        for(int i = 1 ; i < intervals.length ; i++){
            int[] interval = intervals[i];


            if(temp[1] >= interval[0]){
                temp[1] = interval[1];
            }else{
                list.add(temp);
                temp = interval;
            }
        }
        list.add(temp);
        int[][] ret = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
