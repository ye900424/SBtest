package bs.array;

/**
 * @author C.A.O
 * @date 2020/3/12
 */
public class ArrayUtil {

    public static int[] createIntArr(){
        int[] arr = new int[10];
        for(int i = 0 ; i< 10 ; i++){
            arr[i] = (int) (Math.random() * 10)/1;
        }
        return arr;
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print("[ ");
            System.out.print(i);
            System.out.print(" ]");
        }
    }
}
