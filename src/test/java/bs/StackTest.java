package bs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author C.A.O
 * @date 2020/3/4
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        StackTest instance = new StackTest();
        instance.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0 ; i < nums2.length ; i++){
            map.put(nums2[i],i);
        }

        int[] res = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            res[i] = -1;
            for(int j = (map.get(nums1[i]) + 1); j < nums2.length ; j++){
                if(nums1[i] < nums2[j]){
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    public int calPoints(String[] ops) {

        Stack<Integer> score = new Stack();
        for(int i = 0 ; i < ops.length ; i++){
            switch (ops[i]){
                case "+":
                    int pre = score.pop();
                    int curScore = pre + score.peek();
                    score.push(pre);
                    score.push(curScore);
                    break;
                case "D":
                    score.push(score.peek() * 2);
                    break;
                case "C":
                    score.pop();
                    break;
                default:
                    score.push(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;

        while (!score.empty())
            sum += score.pop();
        return sum;

    }
}
