package special.islands;

/**
 * User: caserwin
 * Date: 2021/10/10 9:38 上午
 * Description: 岛屿数量
 */
public class Code200R1 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new Code200R1().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid.length == 0) {
            return num;
        }

        if (grid[0].length == 0) {
            return num;
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    /**
     * 1. 不需要任何返回，说明就是递推式DFS，不需要维护方法外的全局变量
     * 2. 核心技巧是把dfs中走过的路径都置为0，dfs 返回后，外部方法就可以跳过 0。
     */
    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
