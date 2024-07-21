package bs2024.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort instance = new MergeSort();
        int[] nums = new int[]{2, 5, 8, 3, 3,4, 7, 3, 5, 6};
        instance.mergeSort(nums,0,nums.length -1 );

        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public void mergeSort(int[] nums,int left, int right){
        if(left >= right){
            return ;
        }
        int mid = (left +right)/2;

        mergeSort(nums,left,mid);
        mergeSort(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }

    public void merge(int[] arr, int left,int mid ,int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        Queue<String> queue = new LinkedList();

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }
}
