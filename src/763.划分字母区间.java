import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class PartitionLabels {
    // public List<Integer> partitionLabels(String s) {
    //     Map<Character, Integer> lastWordPos = new HashMap<>();
    //     List<Integer> stringLengthList = new ArrayList<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         lastWordPos.put(s.charAt(i), i);
    //     }
    //     int lastPeriodEnd = -1;
    //     int currentEnd = lastWordPos.get(s.charAt(0));
    //     for (int i = 0; i < s.length(); i++) {
    //         char currentChar = s.charAt(i);
    //         // 还在当前片段之中
    //         if (i <= currentEnd) {
    //             int currentCharEnd = lastWordPos.get(currentChar);
    //             if (currentCharEnd > currentEnd) {
    //                 currentEnd = currentCharEnd;
    //             }
    //         }
    //         // 当前片段结束，进入下一片段
    //         else {
    //             stringLengthList.add(currentEnd - lastPeriodEnd);
    //             lastPeriodEnd = currentEnd;
    //             currentEnd = lastWordPos.get(currentChar);
    //         }
    //     }
    //     stringLengthList.add(s.length() - 1 - lastPeriodEnd);
    //     return stringLengthList;
    // }
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String testString = new String("ababcbacadefegdehijhklij");
        System.out.println(solution.partitionLabels(testString));
    }
}
// @lc code=end
