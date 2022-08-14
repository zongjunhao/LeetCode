/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        System.out.println(maxChunksToSorted.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        // System.out.println(maxChunksToSorted.maxChunksToSorted(new int[]{1, 2, 3, 4, 5}));
    }
}
// @lc code=end

