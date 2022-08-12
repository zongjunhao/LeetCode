/*
 * @lc app=leetcode.cn id=761 lang=java
 *
 * [761] 特殊的二进制序列
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// @lc code=start
class MakeLargestSpecial {
    /**
     * 递归地将每个特殊二进制序列拆分为一系列子序列，对子序列进行排序，将排序结果拼接后返回
     * @param s 特殊二进制序列
     * @return 交换后结果
     */
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0;
        int left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        subs.sort(Comparator.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String sub: subs){
            result.append(sub);
        }
        return result.toString();
    }



    public static void main(String[] args) {
        MakeLargestSpecial solution = new MakeLargestSpecial();
        String s = "11011000";
        System.out.println(solution.makeLargestSpecial(s));
    }
}
// @lc code=end

