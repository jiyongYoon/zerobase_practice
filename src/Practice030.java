// Q5. 영토의 둘레 길이 구하기
//     grid[i][j]의 값이 1이면 영토, 0이면 땅.
//     1) grid 한 cell 길이는 1
//     2) 지도에는 독립된 하나의 영토만 존재(분리된 땅 없음)
//     3) 땅 내부에는 물이 존재하지 않음
//     (내 풀이는 2,3번 조건이 없어도 사용 가능)
public class Practice030 {
    static void groundLength(int[][] grid) {
        int xlength = grid[0].length; // 행렬의 가로길이
        int ylength = grid.length; // 행렬의 세로길이
        int count = 0; // 왼->오, 위->아래 훑으면서 땅(1), 물(0) 변하는 수 카운트
        //1 by 1 처리
        if (grid.length == 1 && grid[0].length == 1) {
            if (grid[0][0] == 0) {
                System.out.println(0);
            } else {
                System.out.println(4);
            }
        } else {
            //왼->오 갈때 카운트
            for (int i = 0; i < ylength; i++) {
                for (int j = 0; j < xlength - 1; j++) {
                    if (grid[i][j] + grid[i][j + 1] == 1) {
                        count++;
                    }
                }
            }
            //위->아래 갈때 카운트
            for (int i = 0; i < xlength; i++) {
                for (int j = 0; j < ylength - 1; j++) {
                    if (grid[j][i] + grid[j + 1][i] == 1) {
                        count++;
                    }
                }
            }
            //사이드 땅 카운트
            //맨윗줄
            for (int i = 0; i < xlength; i++) {
                count += grid[0][i];
            }
            //맨아랫줄
            for (int i = 0; i < xlength; i++) {
                count += grid[ylength - 1][i];
            }
            //맨왼쪽줄
            for (int i = 0; i < ylength; i++) {
                count += grid[i][0];
            }
            //맨오른쪽줄
            for (int i = 0; i < ylength; i++) {
                count += grid[i][xlength - 1];
            }
            //둘레 출력
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        groundLength(new int[][]{{1}});
        groundLength(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        groundLength(new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 0, 1}});
        groundLength(new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }
}
