package bs2024.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort instance = new HeapSort();
        int[] nums = new int[]{2, 5, 8, 3, 3,4, 7, 3, 5, 6};
        instance.heapSort1(nums);

        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));

    }

    // 大顶堆
    public void heapSort1(int[] nums) {
        int length = nums.length;
        for (int i = length / 2 -1; i >= 0 ; i--) {
            shiftDown(nums, i, nums.length);
        }

        // 逐个删除顶部节点
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i);
            shiftDown(nums, 0, i);
        }
    }

    public void shiftDown(int[] nums, int index, int len) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest == index){
            return;
        }
        swap(nums, largest, index);
        shiftDown(nums, largest, len);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
