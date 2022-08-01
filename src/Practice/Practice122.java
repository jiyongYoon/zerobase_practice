// 프로그래머스 Lv.2 컬러링북
// https://school.programmers.co.kr/learn/courses/30/lessons/1829
/*
전형적인 bfs, dfs 문제
 */

package Practice;

public class Practice122 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int thisTypeSize;
    public static void dfs(int i, int j, int bfsType, int[][] curPicture) {
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < curPicture.length && y >= 0 && y < curPicture[0].length && curPicture[x][y] != 0 && curPicture[x][y] == bfsType) {
                curPicture[x][y] = 0;
                thisTypeSize++;
                dfs(x, y, bfsType, curPicture);
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] curPicture = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curPicture[i][j] = picture[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                thisTypeSize = 0;
                if(curPicture[i][j] != 0) {
                    thisTypeSize = 1;
                    int bfsType = picture[i][j];
                    curPicture[i][j] = 0;
                    dfs(i, j, bfsType, curPicture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, thisTypeSize);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        System.out.println(solution(m, n, picture));

    }
}
