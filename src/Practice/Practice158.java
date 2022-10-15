// 프로그래머스 Lv.2 행렬의 곱셈
// https://school.programmers.co.kr/learn/courses/30/lessons/12949

package Practice;

public class Practice158 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int time = arr2.length;

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < time; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = { {1, 4}, {3, 2}, {4, 1} };
        int[][] arr2 = { {3}, {3} };

        System.out.println(solution(arr1, arr2));
    }
}
