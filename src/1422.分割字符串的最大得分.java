/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class MaxScore {
    public int maxScore(String s) {
        int numOf0 = 0;
        int numOf1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                ++numOf0;
            } else {
                ++numOf1;
            }
        }

        int leftScore = 0;
        int rightScore = numOf1;
        int maxScore;
        if(s.charAt(0) == '0'){
            ++leftScore;
        }else{
            --rightScore;
        }
        maxScore = leftScore + rightScore;

        for(int i = 1; i < s.length()-1; i++){
            if(s.charAt(i) == '0'){
                ++leftScore;
            } else {
                --rightScore;
            }
            if (leftScore + rightScore > maxScore){
                maxScore = leftScore + rightScore;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        MaxScore solution = new MaxScore();
        System.out.println(solution.maxScore("011101"));
    }
}
// @lc code=end

