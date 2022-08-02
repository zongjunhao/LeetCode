/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int frontPointer = 0;
        int lastPointer = numbers.length -1 ;
        while (frontPointer < lastPointer) {
            if (numbers[frontPointer] + numbers[lastPointer] == target) {
                return new int[]{frontPointer, lastPointer};
            } else if (numbers[frontPointer] + numbers[lastPointer] > target) {
                lastPointer--;
            } else {
                frontPointer++;
            }
        }
        return null;
    }
}
// @lc code=end

