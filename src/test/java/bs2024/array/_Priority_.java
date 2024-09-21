package bs2024.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class _Priority_ {
    public static void main(String[] args) {
        _Priority_ instance = new _Priority_();
        System.out.println(instance.findKthLargest(new int[]{1,2,3,5},1));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length,(o1,o2)->o2-o1);
        for(int i : nums){
            queue.add(i);
        }



        int ret = 0;
        for(int i = 0 ; i < k ; i++){
            if(i == k - 1){
                ret = queue.remove();
            }else {
                queue.remove();
            }
        }

        return ret;
    }
}
