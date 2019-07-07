package range_80_100;

public class No80_RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int currentNum = Integer.MAX_VALUE;
        int currentNumCount = 0;
        int removedNumCount = 0;
        for (int i = 0; i < nums.length; i++){
            if (currentNum == nums[i]){
                if (currentNumCount == 2){
                    nums[i] = Integer.MAX_VALUE;
                    removedNumCount++;
                } else {
                    currentNumCount++;
                }

                continue;
            }

            currentNum = nums[i];
            currentNumCount = 1;
        }

        if (removedNumCount == 0){
            return nums.length;
        }

        int removedValueIndex = 0;
        while (true){
            while (nums[removedValueIndex] != Integer.MAX_VALUE) {
                removedValueIndex++;
            }

            if (removedValueIndex >= nums.length - removedNumCount){
                break;
            }

            int valueIndex = removedValueIndex;
            while (nums[valueIndex] == Integer.MAX_VALUE){
                valueIndex++;
            }

            nums[removedValueIndex] = nums[valueIndex];
            nums[valueIndex] = Integer.MAX_VALUE;
        }

        return nums.length - removedNumCount;
    }
}
