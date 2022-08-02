/*
 * @lc app=leetcode.cn id=2293 lang=java
 *
 * [2293] 极大极小游戏
 */

// @lc code=start
class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int length = nums.length;
        while (length != 1) {
            int couple = 0;
            for (int i = 0; i < length;) {
                // 一个最小,一个最大，每轮结果保存到前半部分
                if (couple % 2 == 0) {
                    nums[couple] = Math.min(nums[i], nums[i + 1]);
                } else {
                    nums[couple] = Math.max(nums[i], nums[i + 1]);
                }
                i += 2;
                couple++;
            }
            // 实际有意义的长度
            length = couple;
        }
        return nums[0];
    }
}
// @lc code=end
