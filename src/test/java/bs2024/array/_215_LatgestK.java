package bs2024.array;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.PriorityQueue;

public class _215_LatgestK {
    public static void main(String[] args) {
        _215_LatgestK instance = new _215_LatgestK();
        System.out.println(instance.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i : nums){
            if(queue.size() == k){
                int temp = queue.peek();
                if(temp < i){
                    queue.remove();
                    queue.add(i);
                }
            }else{
                queue.add(i);
            }
        }

        return queue.remove();
    }
}
