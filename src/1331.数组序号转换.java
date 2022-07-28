/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = new int[arr.length];
        System.arraycopy(arr, 0, sortedArray, 0, arr.length);
        Arrays.sort(sortedArray);
        Map<Integer, Integer> ranks = new HashMap<>();
        int[] ans = new int[arr.length];
        for (int a: sortedArray){
            if (!ranks.containsKey(a)){
                ranks.put(a, ranks.size()+1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
// @lc code=end

