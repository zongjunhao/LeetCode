/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distanceSet = new HashSet<>();
        distanceSet.add(getDistance(p1, p2));
        distanceSet.add(getDistance(p1, p3));
        distanceSet.add(getDistance(p1, p4));
        distanceSet.add(getDistance(p2, p3));
        distanceSet.add(getDistance(p2, p4));
        distanceSet.add(getDistance(p3, p4));
        return distanceSet.size() == 2 && !distanceSet.contains(0);
    }

    public int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();
        int[] p1 = new int[]{0, 0};
        int[] p2 = new int[]{1, 1};
        int[] p3 = new int[]{1, 0};
        int[] p4 = new int[]{1, 1};
        System.out.println(validSquare.validSquare(p1, p2, p3, p4));
    }
}
// @lc code=end

