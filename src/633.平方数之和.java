/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right){
            long result = (long)left * left + (long)right * right;
            if(result < c){
                ++left;
            } else if (result > c){
                --right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeSquareSum solution = new JudgeSquareSum();
        System.out.println(solution.judgeSquareSum(2147483600));
    }
}
// @lc code=end

