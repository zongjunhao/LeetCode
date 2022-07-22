import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] candyNumbers = new int[ratings.length];
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNumbers[i] = candyNumbers[i - 1] + 1;
            }
        }
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candyNumbers[i - 1] = Math.max(candyNumbers[i] + 1, candyNumbers[i - 1]);
            }
        }
        return length+Arrays.stream(candyNumbers).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[] { 1, 0, 2}));
    }
}
// @lc code=end
