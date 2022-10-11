// 프로그래머스 Lv.2 게임 맵 최단거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class Practice154 {
    static class Here {
        int x;
        int y;
        int cnt;

        public Here(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] grid;
    static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static Queue<Here> queue;
    public static int solution(int[][] maps) {
        grid = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];


        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                grid[i][j] = maps[i][j];
            }
        }

        queue = new LinkedList<>();

        queue.add(new Here(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Here cur = queue.poll();
            if(cur.x == grid.length - 1 && cur.y == grid[0].length - 1) {
                return cur.cnt;
            }

            for (int[] d : dir) {
                int x = cur.x + d[0];
                int y = cur.y + d[1];
                if(x >= 0 && y >= 0 && x < maps.length && y < maps[0].length && grid[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Here(x, y, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
}
