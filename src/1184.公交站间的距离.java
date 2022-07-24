import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 环形总距离
        int allDistance = Arrays.stream(distance).sum();
        // 总站数
        int posNum = distance.length;
        // 顺时针方向长度
        int clockwiseDistance = 0;
        for (int currentPos = start; currentPos != destination; currentPos = (currentPos + 1) % posNum) {
            clockwiseDistance += distance[currentPos];
        }
        return Math.min(clockwiseDistance, allDistance - clockwiseDistance);
    }

    public static void main(String[] args) {
        int[] distance = new int[] { 1, 2, 3, 4 };
        int start = 0;
        int destination = 3;
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
    }
}
// @lc code=end
