package bs;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
 * 有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：
 *
 * 如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
 * 如果 S[i] == 'I'，那么 P[i] < P[i+1]。
 * 有多少个有效排列？因为答案可能很大，所以请返回你的答案模 10^9 + 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-permutations-for-di-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author C.A.O
 * @date 2020/1/20
 */
public class test2 {

    public static void main(String[] args) {
        String did = "DIDIDID123哈哈";
        System.out.println(handle(did));
    }

    public static int handle(String did){
        int n = did.length() + 1;
        int count  = 0;

        final List<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i);
        }

        for(int i = 0 ;i < n;i++){

        }



        for(int i = 0 ; i<did.length();i++){
            char single = did.charAt(i);
            System.out.println(single);
        }

        return Integer.MAX_VALUE;
    }

    void sumCount(int index,int[] array){
//        if(){
//
//        }

    }
}
