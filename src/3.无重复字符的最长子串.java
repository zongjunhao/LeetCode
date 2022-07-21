/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class LongestSubstring {
    // public int lengthOfLongestSubstring(String s) {
    //     int startPos = 0;
    //
    //     String longestSubString = "";
    //     for (int currentEndPos = 1; currentEndPos < s.length() + 1; currentEndPos++) {
    //         // 当前截取的子串
    //         String tempString = s.substring(startPos, currentEndPos);
    //         if (tempString.length() > longestSubString.length()) {
    //             longestSubString = tempString;
    //         }
    //         if (currentEndPos == s.length()) {
    //             break;
    //         }
    //         char nextChar = s.charAt(currentEndPos);
    //         int indexOfNextChar = tempString.indexOf(nextChar);
    //         // 下一个字符在当前截取的子串
    //         if (indexOfNextChar != -1) {
    //             startPos += indexOfNextChar + 1;
    //         }
    //     }
    //     return longestSubString.length();
    // }
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        // String s = "abcabcbb";
        // String s = "bbbbb";
        String s = "pwwkewa";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s));
    }
}
// @lc code=end

