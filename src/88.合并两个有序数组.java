/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        int finalPointer = m + n - 1;
        while (nums1Pointer >= 0 && nums2Pointer >= 0) {
            if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[finalPointer] = nums1[nums1Pointer];
                nums1Pointer--;
                finalPointer--;
            } else {
                nums1[finalPointer] = nums2[nums2Pointer];
                nums2Pointer--;
                finalPointer--;
            }
        }
        if (nums2Pointer < 0) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, 0, nums2Pointer + 1);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
// @lc code=end

