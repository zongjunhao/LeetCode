/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Comparator<int[]> comparator = Comparator.comparingInt(interval -> interval[1]);
        Arrays.sort(intervals, comparator);
        int removed = 0;
        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                removed++;
            } else {
                preEnd = intervals[i][1];
            }
        }
        return removed;
    }


    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int[][] intervals = new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(intervals));
    }
}
// @lc code=end

