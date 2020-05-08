package bs.array;

/**
 * @author C.A.O
 * @date 2020/3/12
 */
public class ArrayUtil {

    public static int[] createIntArr(){
        return createIntArr(10);
    }

    public static int[] createIntArr(int n){
        int[] arr = new int[n];
        for(int i = 0 ; i< n ; i++){
            arr[i] = (int) (Math.random() * 10)/1;
        }
        print(arr);
        return arr;
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print("[ ");
            System.out.print(i);
            System.out.print(" ]");
        }
        System.out.println();
    }
}
