package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;

public class _78_subsets {

    public static void main(String[] args) {
        _78_subsets instance = new _78_subsets();
        System.out.println(instance.subsets(new int[]{1,2,3}));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList();
        List<Integer> ret ;
        int maxCount = nums.length;
        for(int i = 0 ; i <= maxCount ; i++){
            ret = new ArrayList();
            traceback(retList,ret,nums,i,0);
        }
        return retList;

    }

    public void traceback(List<List<Integer>> retList,List<Integer> ret,int[] nums,int count,int start){
        if(count == 0){
            retList.add(ret);
            return ;
        }

        if(ret.size() == count){
            List<Integer> temp = new ArrayList();
            temp.addAll(ret);
            retList.add(temp);
            return;
        }

        for(int i = start; i< nums.length;i++){
            ret.add(nums[i]);
            traceback(retList,ret,nums,count,i + 1);
            ret.remove(ret.size() -1);
        }
    }
}
