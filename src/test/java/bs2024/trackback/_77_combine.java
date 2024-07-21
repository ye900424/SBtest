package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;

public class _77_combine {
    public static void main(String[] args) {
        _77_combine instance = new _77_combine();
        System.out.println(instance.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new ArrayList();
        List<Integer> temp = new ArrayList();
//        for(int i = 1 ; i <= n-k+1 ; i++){
            trackBack(retList,temp,n,k,1);
//        }

        return retList;
    }

    public void trackBack(List<List<Integer>> retList,List<Integer> temp,int n, int k,int m){
        if(temp.size() == k ){
            List<Integer>  ret = new ArrayList();
            ret.addAll(temp);
            retList.add(ret);
            return;
        }

        for(int i = m ; i <= n ; i++){
            temp.add(i);
            trackBack(retList,temp,n,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
