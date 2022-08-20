/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class SolveSudoku {
    // 数字j在第i行有没有出现过
    private boolean[][] line = new boolean[9][9];
    // 数字j在第i列有没有出现过
    private boolean[][] column = new boolean[9][9];
    // 数字k在第i,j个宫有没有出现过
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = true;
                    line[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    /**
     * 深度优先遍历尝试
     *
     * @param board 九宫格
     * @param pos   要填充的位置在space中的索引
     */
    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

}
// @lc code=end

