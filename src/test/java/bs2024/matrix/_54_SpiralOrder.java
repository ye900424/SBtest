package bs2024.matrix;

import bs2024.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralOrder {
    public static void main(String[] args) {
        _54_SpiralOrder instance = new _54_SpiralOrder();
        List ret = instance.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(ret);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ret = new ArrayList();

        int u = 0 ;
        int d = m - 1;
        int l = 0 ;
        int r = n - 1;

        while(true){
            for(int i = l ; i <= r ; i++){
                ret.add(matrix[u][i]);
            }
            u++;
            if(u > d){
                break;
            }

            for(int i = u ; i <= d ; i++){
                ret.add(matrix[i][r]);
            }
            r--;
            if(l > r){
                break;
            }

            for(int i = r ; i >= l ; i--){
                ret.add(matrix[d][i]);
            }
            d--;
            if(u > d){
                break;
            }

            for(int i = d; i >= u ;i--){
                ret.add(matrix[i][l]);
            }
            l++;
            if(l > r){
                break;
            }
        }

        return ret;
    }


}
