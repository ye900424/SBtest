package bs2024.string_;

public class _7_reverse {
    public static void main(String[] args) {
        _7_reverse instance = new _7_reverse();
        System.out.println(instance.reverse(123));
    }

    public int reverse(int x) {
        int sum = 0 ;

        while( x != 0){
            int temp = x % 10;
            if(sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && temp > Integer.MAX_VALUE%10)){
                return 0;
            }

            if(sum < Integer.MIN_VALUE/10 || (sum == Integer.MIN_VALUE/10 && temp < Integer.MIN_VALUE%10)){
                return 0;
            }
            sum = sum * 10 + temp;
            x /= x;
        }

        return sum;
    }
}
