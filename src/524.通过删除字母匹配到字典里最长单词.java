/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// @lc code=start
class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> result = new ArrayList<>();
        for (String word : dictionary) {
            int wordPointer = 0;
            for (int strPointer = 0; strPointer < s.length(); strPointer++) {
                if (s.charAt(strPointer) == word.charAt(wordPointer)) {
                    wordPointer++;
                    if (wordPointer == word.length()) {
                        result.add(word);
                        break;
                    }
                }
            }
        }

        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o2.length(), o1.length());
            }
        };

        result.sort(comparator);
        if (result.isEmpty()) {
            return "";
        } else {
            return result.get(0);
        }
    }

    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(findLongestWord.findLongestWord(s, dictionary));
    }
}
// @lc code=end

