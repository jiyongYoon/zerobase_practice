// 프로그래머스 Lv.2 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994#

package Practice;

public class Practice156 {

    public static int solution(String dirs) {
        int answer = 0;

        int[][] dir = { {0, 2}, {0, -2}, {-2, 0}, {2, 0} };
        boolean[][] visited = new boolean[22][22];
        char[] cArr = dirs.toCharArray();

        int[] here = {10, 10};

        for (int i = 0; i < cArr.length; i++) {
            char cur = cArr[i];
            int[] move = new int[2];
            if(cur == 'U') {
                move = dir[0];
            } else if(cur == 'D') {
                move = dir[1];
            } else if(cur == 'L') {
                move = dir[2];
            } else {
                move = dir[3];
            }

            int x = here[0] + move[0];
            int y = here[1] + move[1];

            int lineX = here[0] + (move[0] / 2);
            int lineY = here[1] + (move[1] / 2);

            if(x >= 0 && x < 22 && y >= 0 && y < 22) {
                if(!visited[lineX][lineY]) {
                    visited[lineX][lineY] = true;
                    answer++;
                }
                here[0] = x;
                here[1] = y;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
}
