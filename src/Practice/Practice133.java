// 릿코드 200. 섬의 갯수
// https://leetcode.com/problems/number-of-islands/

package Practice;

public class Practice133 {
    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static int answer = 0;
    public static int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void dfs(int a, int b, char[][] grid) {
        for (int[] d : dir) {
            int x = a + d[0];
            int y = b + d[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                grid[x][y] = '0';
                dfs(x, y, grid);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }
}
