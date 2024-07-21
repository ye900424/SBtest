package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;

public class _39combinationSum {
    public static void main(String[] args) {
        _39combinationSum instance = new _39combinationSum();
        System.out.println(instance.combinationSum(new int[]{2,3,6,7},7));
    }

     List<List<Integer>> retList;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        retList = new ArrayList();
        this.target = target;
        backtrack(new ArrayList(),candidates,0,0);
        return retList;
    }

    public void backtrack(List<Integer> ret,int[] candidates, int sum,int start){
        for(int i = start ; i < candidates.length ; i++){
            if(sum > target){
                return;
            }

            if(sum == target){
                List<Integer> temp = new ArrayList();
                temp.addAll(ret);
                retList.add(temp);
                return;
            }

            sum += candidates[i];
            ret.add(candidates[i]);
            backtrack(ret,candidates,sum,i);
            ret.remove(ret.size()-1);
            sum -= candidates[i];
        }
    }
}
