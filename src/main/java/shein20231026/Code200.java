package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/30 07:41
 * Description:
 */
public class Code200 {

    public int numIslands(char[][] grid) {
        int num = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    num += 1;
                    dfs(grid, n,m,i,j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int n, int m, int i, int j){
        // 判断往下是否连接，如果连接设置为 0。
        if (i + 1 < n && j <m && grid[i + 1][j] == '1'){
            grid[i + 1][j] = '0';
            dfs(grid, n, m, i+1, j);
        }

        // 判断往右是否连接，如果连接设置为 0。
        if (i < n && j + 1 < m && grid[i][j+1] == '1'){
            grid[i][j+1] = '0';
            dfs(grid, n, m, i, j+1);
        }

        // 判断往左是否连接，如果连接设置为 0。
        if (i < n && j - 1 < m && j - 1 >=0 && grid[i][j-1] == '1'){
            grid[i][j-1] = '0';
            dfs(grid, n,m,i,j-1);
        }

        // 判断往上上是否连接，如果连接设置为 0。
        if (i-1 < n && i - 1 >=0 && j < m && grid[i -1][j] == '1'){
            grid[i-1][j] = '0';
            dfs(grid, n,m,i-1,j);
        }
    }
}
