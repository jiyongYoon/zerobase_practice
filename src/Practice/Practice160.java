// 프로그래머스 Lv.1 삼총사
// https://school.programmers.co.kr/learn/courses/30/lessons/131705

package Practice;

public class Practice160 {
    static boolean[] visited;
    static int[] out;
    static int answer;
    public static int solution(int[] number) {
        answer = 0;
        visited = new boolean[number.length];
        out = new int[3];

        recur(0, 0, number);

        return answer;
    }

    public static void recur(int depth, int start, int[] number) {
        if(depth == 3) {
            int check = 0;
            for (int i = 0; i < out.length; i++) {
                check += out[i];
            }
            if(check == 0) {
                answer++;
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = number[i];
                recur(depth + 1, i, number);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(solution(number));
    }
}
