/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

import java.util.Stack;

// @lc code=start
class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushPointer = 0;
        int popPointer = 0;
        Stack<Integer> stack = new Stack<>();
        while (popPointer < popped.length){
            if (stack.isEmpty() || stack.peek() != popped[popPointer]) {
                if (pushPointer >= pushed.length) {
                    return false;
                }
                stack.push(pushed[pushPointer]);
                pushPointer++;
            } else {
                stack.pop();
                popPointer++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
// @lc code=end

