package bs.sort;

import java.util.Arrays;

/**
 * @author C.A.O
 * @date 2020/2/24
 */
public class QuickSort {

    public static void main(String[] args) throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[10];
        arr[0] = 6;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 9;
        arr[4] = 7;
        arr[5] = 1;
        arr[6] = 4;
        arr[7] = 2;
        arr[8] = 8;
        arr[9] = 0;

        int[] res = quickSort.sort(arr);
        for(int i : res){
            System.out.println(i);
        }
    }

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 1、分区
     * 2、交换
     *
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        // index 左边的都是已经处理过的数据
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
