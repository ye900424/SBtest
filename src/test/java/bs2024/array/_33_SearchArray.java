package bs2024.array;

public class _33_SearchArray {
    public static void main(String[] args) {
        _33_SearchArray instance = new _33_SearchArray();
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2},0));
    }

    public int search(int[] nums, int target) {

        int left = 0 ; int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) >> 1;

            if(nums[mid] == target){
                return mid;
            }

            // 判断 0~mid 是否有序
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //mid~nums.length -1 是有序的
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
