package bs;

import bs.array.ArrayUtil;

/**
 * 生成长度为N的斐波拉契数列
 *
 * @author C.A.O
 * @date 2020/1/20
 */
public class fib {

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        createFib(N,0,arr);
        ArrayUtil.print(createfib(N,arr));
        System.out.println(createfib(N,arr));
    }

    static int[] createfib (int N,int[] arr){
        if(N < 3){
            return arr;
        }

        for(int i = 2; i< N;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }


    static void createFib(int N , int idx, int[] arr){
        if(idx == N){
            return ;
        }
        if(idx == 0){
            arr[0] = 0;
        }else if(idx == 1){
            arr[1] = 1;
        }else{
            arr[idx] = arr[idx - 2] + arr[idx - 1];
        }
        System.out.println(arr[idx]);
        createFib(N,idx+1,arr);
    }

}
