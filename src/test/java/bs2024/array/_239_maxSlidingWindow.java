package bs2024.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239_maxSlidingWindow {
    public static void main(String[] args) {
        _239_maxSlidingWindow instance = new _239_maxSlidingWindow();
        int ret[] = instance.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(int i : ret){
            System.out.println(i);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.peekFirst()]<nums[i]){
                deque.removeFirst();
            }
            deque.add(i);
        }

        int[] ret = new int[nums.length - k +1];
        ret[0] = nums[deque.peekFirst()];
        for(int i = k ; i < nums.length ; i++){
            while(!deque.isEmpty() && deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.add(i);
            if(deque.peekFirst() == i - k){
                deque.removeFirst();
            }
            ret[i-k+1] = nums[deque.peekFirst()];
        }

        return ret;
    }
}
