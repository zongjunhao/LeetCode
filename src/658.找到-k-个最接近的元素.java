/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分查找，返回最接近x的一个位置
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                break;
            } else if (high - low == 1) {
                if (arr[high] - x < x - arr[low]){
                    mid = high;
                }
                break;
            } else if (arr[mid] < x) {
                low = mid;
            } else {
                high = mid;
            }
        }

        // 分别向左右两侧查找，构造区间
        int count = 1;
        int left = mid;
        int right = mid;
        while (count < k) {
            if ((left - 1 >= 0) && (right + 1 <= arr.length - 1)) {
                // 两侧都有元素可取
                int leftVal = arr[left - 1];
                int rightVal = arr[right + 1];
                if (x - leftVal > rightVal - x) {
                    // 右侧元素相差较小，取右侧元素
                    ++right;
                } else {
                    // 左侧元素相差较小，或两侧元素差值相等，取左侧元素
                    --left;
                }
                ++count;
            } else if (left == 0) {
                // 左侧无元素可取，缺少的元素用右侧的补充满
                right += (k - count);
                count = k;
            } else {
                // 右侧无元素可取，缺少的元素用左侧的补充满
                left -= (k - count);
                count = k;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }
}
// @lc code=end

