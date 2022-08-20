/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        // 仅有一个数字
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (left == right) {
                return nums[mid];
            }
            if (mid - 1 < 0) {
                return nums[0];
            }
            if (mid + 1 > nums.length - 1){
                return nums[nums.length - 1];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            // 单一数字出现前后，奇偶数不同
            int midAdjacent = mid % 2 == 0 ? mid + 1 : mid - 1;
            if (nums[mid] == nums[midAdjacent]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
    }
}
// @lc code=end

