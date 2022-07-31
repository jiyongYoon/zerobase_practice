package Practice;

// 백준 17478번 재귀함수가 뭔가요?
// https://www.acmicpc.net/problem/17478

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice097 {
    static String underbar = "____";
    static String start;
    static String mid;
    static String end1;
    static String end2;

    public static void solution(int n) {
        String sb = "";
        int cnt = 0;
        String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
        System.out.println(start);
        permu(n, cnt, sb);
    }

    public static void permu(int n, int cnt, String s) {
        String sb = (cnt > 0) ? s + underbar : "";

        String mid = sb + "\"재귀함수가 뭔가요?\"\n" +
                sb + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                sb + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                sb + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        String end1 = sb + "\"재귀함수가 뭔가요?\"\n" +
                sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                sb + "라고 답변하였지.";
        String end2 = sb + "라고 답변하였지.";

        if(cnt == n) {
            System.out.println(end1);
            return;
        } else {
            System.out.println(mid);
            permu(n, cnt + 1, sb);
            System.out.println(end2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
/*
[학습내용]
재귀함수 내에서 변경되어 사용될 변수는 재귀메서드 안에서 선언해야 한다.
static으로 지역변수 선언을 하면, 재귀함수를 나오면 다시 돌아가지 못할 수 있다.
 */