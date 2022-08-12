/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class MinWindow {
    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        boolean[] flag = new boolean[128];
        for (int i = 0; i < t.length(); i++) {
            flag[t.charAt(i)] = true;
            chars[t.charAt(i)]++;
        }

        int cnt = 0, left = 0, minLeft = 0, minSize = s.length() + 1;
        for (int right = 0; right < s.length(); right++) {
            if (flag[s.charAt(right)]) {
                if (--chars[s.charAt(right)] >= 0) {
                    cnt++;
                }
                while (cnt == t.length()) {
                    if (right - left + 1 < minSize) {
                        minLeft = left;
                        minSize = right - left + 1;
                    }
                    if (flag[s.charAt(left)] && ++chars[s.charAt(left)] > 0) {
                        cnt--;
                    }
                    left++;
                }
            }
        }
        return minSize > s.length() ? "" : s.substring(minLeft, minLeft + minSize);
    }
}
// @lc code=end

