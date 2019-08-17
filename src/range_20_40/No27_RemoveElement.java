package range_20_40;

/**
 * 指针，数组
 */
public class No27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int realLen = len;
        for(int i=0; i<realLen; i++){
            if(nums[i] == val){
                for(int j=i+1; j<realLen; j++){
                    nums[j-1] = nums[j];
                }
                realLen--;
                i--;
            }
        }
        return realLen;
    }
}
