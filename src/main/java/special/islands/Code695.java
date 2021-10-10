package special.islands;

/**
 * User: caserwin
 * Date: 2021/10/10 1:09 下午
 * Description: 岛屿最大面积
 *
 * 写过 200 题的来写这个，第200 题代码基本复用的
 */
public class Code695 {

    int tmpMaxArea = 0;

    /**
     * 方法一
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    tmpMaxArea = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, tmpMaxArea);
                }
            }
        }
        return maxArea;
    }


    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        tmpMaxArea++;
        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }


    /**
     * 方法二：递推式 dfs
     */
    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        // 1. 边界判断条件，这里最好写0，而不是 Integer.MIN_VALUE
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs1(grid, i, j));
                }
            }
        }
        return maxArea;
    }


    private int dfs1(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs1(grid, r + 1, c) + dfs1(grid, r - 1, c) + dfs1(grid, r, c + 1) + dfs1(grid, r, c - 1);
    }
}
