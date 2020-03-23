package bs.sort;

import bs.array.ArrayUtil;

/**
 * 半成品，重点参考bishi.sort.QuickSort
 *
 *
 * @author C.A.O
 * @date 2020/3/12
 */
public class QuickSort3 {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.createIntArr();
        ArrayUtil.print(arr);
    }

    public int[] sort(int[] arr,int left, int right){
        // 1、分区
        if(left >= right){
            return arr;
        }
        int idx = partition(arr,0,arr.length -1);
        partition(arr,left,idx - 1);
        partition(arr,idx +1 ,right);
        return null;
    }

    public int partition(int[] arr,int left, int right){
        int povit = left;
        int idx = left + 1;
        for(int i = idx; i < right; i++){
            if(arr[i] < arr[povit]){
                swap(arr,idx-1,i);
                idx++;
            }
        }
        swap(arr,povit,idx);
        return 0;
    }

    public void swap(int[] arr,int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
