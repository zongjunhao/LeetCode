/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

import java.util.Arrays;

// @lc code=start
class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            // 当前饼干能够满足当前孩子的胃口，遍历下一个孩子
            if (g[child] <= s[cookie]) {
                child++;
            }
            // 无论能否满足胃口都要遍历下一个饼干
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildren(g, s));
    }
}
// @lc code=end

