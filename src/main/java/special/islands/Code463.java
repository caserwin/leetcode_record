package special.islands;

/**
 * Description: 岛屿的周长
 * 看过解题思路，核心点在于
 * 1. 区分水域方格、边界方格、已走过方格类型。
 * 2. 针对不同类型的周长计算方式不太一样。
 * 3. 补充说明：其实没啥意思，dfs 思想和 200 题没区别，这题感觉最难的是考查如何统计周长，而不是 dfs 思想。
 */
public class Code463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
