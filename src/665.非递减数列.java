/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        int decreaseNum = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                decreaseNum++;
                if (decreaseNum > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1] && i < length - 2 && nums[i] > nums[i + 2]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        int[] nums = new int[]{5, 7, 1, 8};
        System.out.println(checkPossibility.checkPossibility(nums));
    }
}
// @lc code=end

