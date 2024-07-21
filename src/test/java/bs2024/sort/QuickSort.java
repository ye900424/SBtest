package bs2024.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{3,2,1,5,6,4};
        quickSort.doSort(nums,0,nums.length -1);
        Arrays.stream(nums).forEach(x-> System.out.print(x));

    }

    public void doSort(int[] nums,int startIdx,int endIdx){
        if(startIdx >= endIdx){
            return;
        }

        int pIdx = partition(nums,startIdx,endIdx);
        doSort(nums,startIdx,pIdx-1);
        doSort(nums,pIdx+1,endIdx);

    }

    private int partition(int[] nums,int startIdx,int endIdx){
        int pVal = nums[startIdx];
        int lIdx = startIdx;
        int rIdx = endIdx;

        while (lIdx < rIdx){
            while (nums[rIdx] >= pVal && lIdx < rIdx){
                rIdx--;
            }
            while(nums[lIdx] <= pVal && lIdx < rIdx){
                lIdx++;
            }

            swap(nums,lIdx,rIdx);
        }
        swap(nums,lIdx,startIdx);
        return lIdx;
    }

    /*
     * 分治法（单边循环法）
     * arr  待排序数组
     * startIndex  起始下标
     * endIndex  结束下标
     * */
//    public int partition(int arr[],int startIndex,int endIndex)
//    {
//        int p=arr[startIndex];//基准元素(可取随机位置)
//        int mark=startIndex;
//
//        for(int i=startIndex+1;i<=endIndex;i++){
//            if(arr[i]<p){
//                mark++;
//                swap(arr,mark,i);
//            }
//        }
//
//        //交换基准元素和mark指针的元素
//        swap(arr,mark,startIndex);
//        return mark;
//    }


//    private int partition(int[] nums,int startIdx,int endIdx){
//        int p = nums[startIdx];
//        int index = startIdx;
//        for(int i = startIdx + 1 ; i <= endIdx ; i++){
//            if(nums[i] < p){
//                index ++;
//                swap(nums,index,i);
//            }
//        }
//        swap(nums,startIdx,index);
//
//        return index;
//    }

    private void swap(int[] nums,int startIdx,int endIdx){
        int temp = nums[startIdx];
        nums[startIdx] = nums[endIdx];
        nums[endIdx] = temp;
    }
}
