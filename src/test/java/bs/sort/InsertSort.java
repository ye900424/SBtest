package bs.sort;

/**
 * 插入排序
 *
 * @author C.A.O
 * @date 2020/1/15
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 9;
        arr[1] = 8;
        arr[2] = 4;
        arr[3] = 6;
        arr[4] = 2;
        arr[5] = 5;
        arr[6] = 3;
        arr[7] = 7;
        arr[8] = 9;
        arr[9] = 1;

        int[] resultArr = sort(arr);

        for (int i : resultArr) {
            System.out.println(i);
        }

    }


    public static int[] sort(int[] sourceArr) {
        for (int i = 0; i < sourceArr.length - 1; i++) {
            int ele = sourceArr[i + 1];

            int idx = i;
            while (idx >= 0 && ele < sourceArr[idx]) {
                sourceArr[idx + 1] = sourceArr[idx];
                idx--;
            }
            sourceArr[idx + 1] = ele;
        }


        return sourceArr;
    }


}
