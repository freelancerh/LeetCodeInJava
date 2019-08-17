package range_120_140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找规律。自定义数据结构
 */
public class No128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        for (int num : nums){
            if (set.contains(num)){
                continue;
            }

            set.add(num);
            int pre = num - 1;
            int next = num + 1;
            if (map.containsKey(pre) && map.containsKey(next)){
                int start = map.get(pre);
                int end = map.get(next);
                map.remove(pre);
                map.remove(next);
                map.put(start, end);
                map.put(end, start);
                if (maxLength < end - start + 1){
                    maxLength = end - start + 1;
                }

                continue;
            }

            if (map.containsKey(pre)){
                int start = map.get(pre);
                map.remove(pre);
                map.put(start, num);
                map.put(num, start);
                if (maxLength < num - start + 1){
                    maxLength = num - start + 1;
                }

                continue;
            }

            if (map.containsKey(next)){
                int end = map.get(next);
                map.remove(next);
                map.put(end, num);
                map.put(num, end);
                if (maxLength < end - num + 1){
                    maxLength = end - num + 1;
                }

                continue;
            }

            map.put(num, num);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        new No128_LongestConsecutiveSequence().longestConsecutive(new int[]{1,2,0,1});
    }
}
