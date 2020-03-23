package bs.sort;

/**
 * 找出最长的回文子串
 * e.g："baccababadbaaa"  ->  "baccab"
 *
 * @author C.A.O
 * @date 2020/2/1
 */
public class TuoTuo {

    public static void main(String[] args) {
        System.out.printf(fun("baccababadbaaa"));
    }

    public static String fun(String s){

        String result = "";

        for(int i = 0 ; i < s.length() ; i++){
            String rs1 = handle(s,i,i);
            String rs2 = handle(s,i,i+1);
            if(rs1.length() > rs2.length()){
                result = rs1;
            }else {
                result = rs2;
            }

        }
        return result;
    }

    public static String handle(String s, int minIdx,int maxIdx){
        int L = minIdx,R = maxIdx;

         while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
             L--;
             R++;
         }

        return s.substring(L,R);
    }
}
