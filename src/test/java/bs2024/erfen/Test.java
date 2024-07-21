package bs2024.erfen;

public class Test {
    public static void main(String[] args) {
        Test instance = new Test();
//        System.out.println(instance.searchRange(new int[]{5,7,7,8,8,10},8));
        System.out.println(instance.searchRange(new int[]{1},0));
    }

    public int[] searchRange(int[] nums, int target) {
        int f = findFirst(nums,target);
        int l = findLast(nums,target);
        System.out.println("first:"+f +"  last:"+l);
        return new int[]{f,l};
    }

    int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = (left+right+1)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        if(left >= 0 && left < nums.length && nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }

    int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = (left+right+1)/2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        if(right >=0 && right < nums.length && nums[right] == target){
            return right;
        }else{
            return -1;
        }
    }
}
