/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class TwoSum {
    // public int[] twoSum(int[] nums, int target) {
    //     int length = nums.length;
    //     for (int i = 0; i < length; i++) {
    //         for (int j = i + 1; j < length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return new int[] { i, j };
    //             }
    //         }
    //     }
    //     return new int[] { 0, 0 };
    // }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}
// @lc code=end
