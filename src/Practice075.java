// 프로그래머스 Lv.3
// 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105#

public class Practice075 {
    public static int solution(int[][] triangle) {
        int answer = 0;
        // 삼각형을 순회
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0) { // 왼쪽에 붙어서 내려오는 건
                    triangle[i][j] += triangle[i-1][j]; // 윗 줄 왼쪽 벽 숫자 더해서 계속 내려오면 됨
                } else if(j==(triangle[i].length-1)) { // 오른쪽에 붙어서 내려오는건
                    triangle[i][j] += triangle[i-1][j-1]; // 마찬가지로 윗 줄 오른쪽 벽 숫자 더해서 계속 내려오면 됨
                } else { // 가운데 있는 것들은 다 계산할 필요 없이 큰 왼쪽, 오른쪽 중 큰 숫자꺼 골라서 더해서 가져오면 됨
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int answerCol = triangle.length - 1; // 마지막 줄 배열 길이

        for (int i = 0; i < triangle[answerCol].length; i++) {
            if(answer < triangle[answerCol][i]) {
                answer = triangle[answerCol][i]; // 가장 큰 숫자 추리기
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}