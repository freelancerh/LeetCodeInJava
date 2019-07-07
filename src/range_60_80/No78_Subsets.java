package range_60_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null){
            return new ArrayList<>();
        }

        if (nums.length == 0){
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> subResult = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> result = new ArrayList<>(subResult);
        result.addAll(plusN(nums[0], subResult));
        return result;
    }

    private List<List<Integer>> plusN(int n, List<List<Integer>> subSets){
        List<List<Integer>> result = new ArrayList<>(subSets.size() + 1);
        for (List<Integer> subSet : subSets){
            List<Integer> newSubSet = new ArrayList<>(subSet);
            newSubSet.add(n);
            result.add(newSubSet);
        }

        List<Integer> singleValueSet = new ArrayList<>();
        singleValueSet.add(n);
        result.add(singleValueSet);
        return result;
    }
}
