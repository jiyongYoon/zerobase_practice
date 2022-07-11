package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

// 백준 2583번
// https://www.acmicpc.net/problem/2583
public class Practice070 {
    public static ArrayList<Integer> area; // 각 분리된 부분의 넓이 배열
    public static int areatmp; // 재귀돌면서 넓이 저장할 변수
    public static int[][] grid; // 땅
    public static void dfs(int[][] grid, int i, int j) {
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // 동서남북
        grid[i][j] = 1; // 1로 바꾸고 (방문배열이 필요한 경우도 있음)
        areatmp++; // 넓이 더하기
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            // 그리드 안에 있으면서, 0인 경우
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==0) {
                dfs(grid, x, y); // 재귀호출
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, times;
        String[] tmp1 = br.readLine().split(" ");
        m = Integer.parseInt(tmp1[0]);
        n = Integer.parseInt(tmp1[1]);
        times = Integer.parseInt(tmp1[2]);

        grid = new int[m][n];
        area = new ArrayList<>();

        // 배열에 1 집어넣기
        for (int i = 0; i < times; i++) {
            int x1, x2, y1, y2;
            String[] tmp2 = br.readLine().split(" ");
            x1 = Integer.parseInt(tmp2[0]);
            y1 = Integer.parseInt(tmp2[1]);
            x2 = Integer.parseInt(tmp2[2]);
            y2 = Integer.parseInt(tmp2[3]);
            for (int j = y1; j < y2; j++) { // <- for문을 돌때
                for (int k = x1; k < x2; k++) { // <- 미리 배열의 인덱스를 제대로 처리해보자
                    grid[j][k] = 1;
                }
            }
        }

        // 배열 돌면서 0이면 dfs돌기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0) {
                    dfs(grid, i, j);
                    area.add(areatmp);
                    areatmp = 0;
                }
            }
        }
        // 출력
        area.sort(Comparator.naturalOrder());
        System.out.println(area.size());
        for (int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }
    }
}

/*
[학습내용]
배열을 다룰 때 함수그래프처럼 눈금에 어떤 작업을 하게 되는 경우
=> 실제 배열에 어떻게 들어갈지 미리 계산해서 투입하는 것이 정신건강에 좋다.
즉, 문제에서는 이 좌표로 들어갔지만 그게 배열로 들어갈땐
어디가 -1이 되어야 하는지, 어디가 좌우가 바뀌어야 하는지 등등을
미리 계산해서 넣자.
 */

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
 */
// 출력
// 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
