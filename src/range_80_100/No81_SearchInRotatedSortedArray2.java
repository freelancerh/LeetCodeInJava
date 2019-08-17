package range_80_100;

/**
 * 查找,数组
 */
public class No81_SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }

        return binarySearch(nums, target, 0, nums.length-1);
    }


    public boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end){
            int mid = (start + end) / 2;
            if (target == nums[mid]){
                return true;
            }

            if (nums[start] < nums[end]){
                if (target > nums[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] > nums[start] || nums[mid] > nums[end]){
                    if (nums[start] <= target && target < nums[mid]){
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] < nums[start] && nums[mid] <= nums[end]){
                    if (nums[mid] < target && target <= nums[end]){
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else if (nums[mid] == nums[start] && nums[mid] == nums[end]){
                    start++;
                }
            }
        }

        return false;
    }
}
