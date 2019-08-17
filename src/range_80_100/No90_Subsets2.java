package range_80_100;

import java.util.*;

/**
 * 数组,集合,递归
 */
public class No90_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null){
            return null;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int num : nums){
            if (valueCountMap.containsKey(num)){
                valueCountMap.put(num, valueCountMap.get(num) + 1);
            } else {
                valueCountMap.put(num, 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=0; i < nums.length;){
            if (valueCountMap.get(nums[i]) > 1){
                List<List<Integer>> tempList = new ArrayList<>();
                for (int k = 1; k <= valueCountMap.get(nums[i]); k++){
                    tempList.addAll(getNewSet(result, nums[i], k));
                }

                result.addAll(tempList);
                i += valueCountMap.get(nums[i]);
            } else {
                result.addAll(getNewSet(result, nums[i], 1));
                i++;
            }
        }

        return result;
    }

    private List<List<Integer>> getNewSet(List<List<Integer>> setList, int num, int count){
        List<List<Integer>> tempList = new ArrayList<>();
        for (List<Integer> value : setList){
            List<Integer> temp = new ArrayList<>(value);
            for (int i = 0; i < count; i++){
                temp.add(num);
            }

            tempList.add(temp);
        }

        return tempList;
    }
}
