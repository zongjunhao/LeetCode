/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

import java.util.Arrays;

// @lc code=start
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int left = mid;
        int right = mid;
        if (nums[mid] == target) {
            while (left > 0) {
                if (nums[left - 1] == target) {
                    --left;
                } else {
                    break;
                }
            }
            while (right < nums.length - 1) {
                if (nums[right + 1] == target) {
                    ++right;
                } else {
                    break;
                }
            }
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{2, 2}, 2)));
    }
}
// @lc code=end

