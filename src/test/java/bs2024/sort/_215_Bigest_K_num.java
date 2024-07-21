package bs2024.sort;

public class _215_Bigest_K_num {

    public static void main(String[] args) {
        _215_Bigest_K_num instance = new _215_Bigest_K_num();
//        System.out.println(instance.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(instance.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    public int findKthLargest(int[] nums, int k) {
        // 使用快排来解决
        findByQuickSort(nums,nums.length - k,0,nums.length-1);
        return nums[nums.length - k];
    }

    public void findByQuickSort(int[] nums, int k,int start,int end){
        if(start >= end){
            return ;
        }

        int p = patition(nums,start,end);
        if(p == k){
            return ;
        }
        if(p>k){
            findByQuickSort(nums,k,start,p-1);
        }else{
            findByQuickSort(nums,k,p+1,end);
        }

    }

    public int patition(int[] nums,int start,int end){
        int i = start;
        int j = end;

        int pVal = nums[start];

        while(i < j){

            while(nums[j] >= pVal && i < j){
                j--;
            }
            while(nums[i] <= pVal && i < j){
                i++;
            }


            swap(nums,i,j);
        }
        swap(nums,i,start);
        return i;
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
