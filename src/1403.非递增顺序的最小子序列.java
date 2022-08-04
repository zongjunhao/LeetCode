import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int currentSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            resultList.add(nums[i]);
            if (currentSum > sum - currentSum) {
                break;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 7, 6, 7};
        MinSubsequence solution = new MinSubsequence();
        System.out.println(solution.minSubsequence(nums));
    }
}
// @lc code=end

