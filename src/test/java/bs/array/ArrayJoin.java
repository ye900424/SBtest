package bs.array;

import java.util.Arrays;

/**
 * @author C.A.O
 * @date 2020/2/29
 */
public class ArrayJoin {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 2;
        arr1[3] = 6;
        arr1[4] = 7;
        int[] arr2 = new int[4];
        arr2[0] = 3;
        arr2[1] = 4;
        arr2[2] = 5;
        arr2[3] = 6;


        int[] resArr = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;

        while(idx1 < arr1.length && idx2 < arr2.length){
            if(arr1[idx1] < arr2[idx2]){
                resArr[idx++] = arr1[idx1++];
            }else if(arr1[idx1] == arr2[idx2]){
                resArr[idx++] = arr1[idx1];
                idx1++;
                idx2++;
            }else{
                resArr[idx++] = arr2[idx2++];
            }
        }

        while (idx1 < arr1.length){
            resArr[idx++] = arr1[idx1 ++];
        }

        while (idx2 < arr2.length){
            resArr[idx++] = arr2[idx2 ++];
        }

        System.out.println(Arrays.toString(resArr));
    }
}
