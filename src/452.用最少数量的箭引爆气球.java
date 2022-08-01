/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return 1;
                }
            }
        };
        Arrays.sort(points, comparator);
        int arrowNum = 1;
        int endPos = points[0][1];
        for (int[] point : points) {
            if (point[0] <= endPos) {
                continue;
            }
            arrowNum++;
            endPos = point[1];
        }
        return arrowNum;
    }

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        int[][] points = new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(findMinArrowShots.findMinArrowShots(points));
    }
}
// @lc code=end

