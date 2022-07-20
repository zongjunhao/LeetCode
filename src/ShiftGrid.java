import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowNum; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < columnNum; j++) {
                row.add(grid[i][j]);
            }
            result.add(row);
        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                int index = (i * columnNum + j + k) % (rowNum * columnNum);
                result.get(index / columnNum).set(index % columnNum, grid[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();
        int[][] grid = new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        int k = 23;
        System.out.println(shiftGrid.shiftGrid(grid, k));
    }
}
