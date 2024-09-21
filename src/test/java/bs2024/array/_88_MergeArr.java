package bs2024.array;

public class _88_MergeArr {
    public static void main(String[] args) {
        _88_MergeArr instance = new _88_MergeArr();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        instance.merge(nums1,3,nums2,3);

        System.out.println(nums1);

        char c = '2';
        int i = 5;
        c = (char) i;
        System.out.println(c-'0');
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = m + n;
        while(m >0 || n>0){
            if(n == 0 || nums1[m - 1] >= nums2[n - 1] ){
                nums1[length - 1] = nums1[m - 1];
                m --;
            }else{
                nums1[length - 1] = nums2[n - 1];
                n --;
            }
            length --;
        }
    }
}
