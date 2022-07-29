/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 可种植的花的总数
        int totalFlowered = 0;
        int flowerbedLength = flowerbed.length;
        // 长度为1
        if (flowerbedLength == 1) {
            if (flowerbed[0] == 0) {
                totalFlowered++;
            }
            return totalFlowered >= n;
        }
        // 长度为2
        if (flowerbedLength == 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                totalFlowered++;
            }
            return totalFlowered >= n;
        }
        // 长度>=3
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            totalFlowered++;
        }
        if (flowerbed[flowerbedLength - 1] == 0 && flowerbed[flowerbedLength - 2] == 0) {
            flowerbed[flowerbedLength - 1] = 1;
            totalFlowered++;
        }
        for (int i = 1; i < flowerbedLength - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                totalFlowered++;
                if (totalFlowered >= n) {
                    return true;
                }
            }
        }
        return totalFlowered >= n;
    }
}
// @lc code=end

