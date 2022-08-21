/*
 * @lc app=leetcode.cn id=1455 lang=java
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int indexOfWord = 1;
        boolean newWord = true;
        for (int i = 0; i < sentence.length(); i++) {
            if (newWord) {
                // 发现新一个单词后，开始匹配
                for (int j = 0; j < searchWord.length(); j++) {
                    if (sentence.charAt(i) == searchWord.charAt(j)) {
                        if (j == searchWord.length() - 1) {
                            return indexOfWord;
                        }
                        i++;
                    } else {
                        newWord = false;
                        break;
                    }
                }
            }
            if (sentence.charAt(i) == ' ') {
                newWord = true;
                indexOfWord++;
            }
            if (i == sentence.charAt(i) - 1) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        IsPrefixOfWord isPrefixOfWord = new IsPrefixOfWord();
        System.out.println(isPrefixOfWord.isPrefixOfWord("leetcode donald", "donal"));
    }
}
// @lc code=end

