// 프로그래머스 Lv.2 피로도
// https://school.programmers.co.kr/learn/courses/30/lessons/87946

package Practice;

public class Practice149 {
    static boolean[] visited;
    static int answer;
    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        recur(k, dungeons, 0);
        return answer;
    }

    public static void recur(int k, int[][] dungeons, int cnt) {
        if(k <= 0) {
            answer = Math.max(cnt, answer);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                cnt++;
                k = k - dungeons[i][1];
                recur(k, dungeons, cnt);
                k = k + dungeons[i][1];
                cnt--;
                visited[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        System.out.println(solution(k, dungeons));
    }
}
