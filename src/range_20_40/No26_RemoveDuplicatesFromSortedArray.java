package range_20_40;

/**
 * 指针，数组
 */
public class No26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length < 1)
            return 0;
        int len = nums.length;
        int j = 1;
        for(int i=1; i<len; i++){
            if(nums[i] != nums[i-1]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
