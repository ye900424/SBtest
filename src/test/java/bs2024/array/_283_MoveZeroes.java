package bs2024.array;

import java.util.LinkedList;
import java.util.Queue;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        _283_MoveZeroes instance = new _283_MoveZeroes();
        instance.moveZeroes(new int[]{1,2,0,5,6,0,0,9});
        Queue<String> queue = new LinkedList<>();
        queue.add(null);
        queue.remove();
        queue.poll();
        System.out.println(queue.size());
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }
    }




    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
