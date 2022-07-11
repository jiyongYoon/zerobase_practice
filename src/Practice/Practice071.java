package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 백준 13460 실패
// https://www.acmicpc.net/problem/13460
//5 5
//#####
//#..B#
//#.#.#
//#RO.#
//#####
//7 7
//#######
//#...RB#
//#.#####
//#.....#
//#####.#
//#O....#
//#######
public class Practice071 {
    public static int n, m, answer, cnt;
    public static int[] red;
    public static int[] blue;
    public static int[] hole;

    public static String[][] grid;
    // 그 방향으로 쭉 움직이기 메서드
    public static void move(int rx, int ry, int bx, int by, int d0, int d1) {
        while(grid[rx][ry].equals(".")) {
            // 빨간공 움직이기
            grid[red[0]][red[1]] = "."; // 있었던 자리 .으로
            grid[rx][ry] = "R"; // 새로 간 자리 R로
            // 같은 방향으로 계속 더해줌
            rx = rx + d0;
            ry = ry + d1;

            // 파란공 움직이기
            if(grid[bx][by].equals("#")) { // 벽이면 안움직이기
                continue;
            } else { // 벽이 아니면
                grid[blue[0]][blue[1]] = "."; // 있었던 자리 .으로
                grid[bx][by] = "B"; // 새로 간 자리 R로
                // 같은 방향으로 계속 더해줌
                bx = bx + d0;
                by = by + d1;
            }
//            cnt++;
        }

        answer++; // 한 방향으로 한번 움직인것
        if(answer>10) {
            answer = -1;
            return;
        }

    }
    public static int bfs(int[] red, int[] blue, int[] hole) {
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] d: dir) {
            int rx = red[0] + d[0];
            int ry = red[1] + d[1];
            int bx = blue[0] + d[0];
            int by = blue[1] + d[1];
            // 빨간공을 기준으로 먼저 움직이고 파란공이 움직임
            if(grid[rx][ry].equals("O")) { // 0을 만나면 파란공 끝까지 작업해줌
                // 벽이나 0 만나기 전까지
                while(grid[bx][by].equals(".")) {
                    grid[blue[0]][blue[1]] = ".";
                    grid[bx][by] = "B";
                    bx = bx + d[0];
                    by = by + d[1];
                }
                // 만약 마지막 움직인게 O을 만나면
                if(grid[bx][by].equals("O")) {
                    answer = -1;
                    break;
                }
            } else if(grid[rx][ry].equals(".")) {
                move(rx, ry, bx, by, d[0], d[1]);
                bfs(red, blue, hole);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        grid = new String[n][m];
        // 미로 그리기
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                grid[i][j] = s[j];
                // 각 위치 저장
                if(grid[i][j].equals("R")) {
                    red = new int[]{i, j};
                } else if(grid[i][j].equals("B")) {
                    blue = new int[]{i, j};
                } else if(grid[i][j].equals("O")) {
                    hole = new int[]{i, j};
                }
            }
        }
        // 맨 처음 바로 옆에 홀이 있는경우 한번 처리
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] d: dir) {
            int rx = red[0] + d[0];
            int ry = red[1] + d[1];
            int bx = blue[0] + d[0];
            int by = blue[1] + d[1];
            // 만약 맨 처음에 걸리면
            if (grid[rx][ry].equals("O")) { // O을 만나면 파란공 끝까지 작업해줌
                answer = 1;
                // 벽이나 0 만나기 전까지
                while (grid[bx][by].equals(".")) {
                    grid[blue[0]][blue[1]] = "."; //
                    grid[bx][by] = "B"; //
                    bx = bx + d[0];
                    by = by + d[1];
                }
                // 만약 마지막 움직인게 O을 만나면
                if (grid[bx][by].equals("O")) {
                    answer = -1;
                }
            }
            if(answer==1 || answer==-1) {
                System.out.println(answer);
            } else {
                System.out.println(bfs(new int[]{rx, ry}, new int[]{bx, by}, hole));
            }
        }
    }
}
