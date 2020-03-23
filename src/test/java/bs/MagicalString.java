package bs;

/**
 * @author C.A.O
 * @date 2020/1/7
 */
public class MagicalString {

    public static void main(String[] args) {

        String str = "122";
        int index = 2;
        int N = 100;

        while(index < N){
            str += str.substring(index -1,index);
        }

        Integer[] array = new Integer[N];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;

        array[3] = 1;

        while (index < N){
            int tail = array[index];

        }


    }
}
