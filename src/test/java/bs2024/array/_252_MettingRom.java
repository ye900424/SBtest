package bs2024.array;

import java.util.ArrayList;
import java.util.List;

public class _252_MettingRom {
    public static void main(String[] args){
        _252_MettingRom instance = new _252_MettingRom();
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(instance.fun(intervals));
    }

    public int fun(int[][] intervals){
        List<int[]> items = new ArrayList<>();
        for(int[] arr : intervals){
            items.add(new int[]{arr[0],1});
            items.add(new int[]{arr[1],-1});
        }

        items.sort((o1, o2) -> o1[0]-o2[0] != 0 ? o1[0]-o2[0] : o1[1] - o2[1]);
        int ret = 0;
        int temp = 0;
        for(int[] arr : items){
            temp += arr[1];
            ret = Math.max(ret,temp);
        }
        return ret;
    }
}
