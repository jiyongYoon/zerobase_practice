// 백준 1759 암호만들기
// https://www.acmicpc.net/problem/1759
// dfs, bfs 성능 비교 https://bangu4.tistory.com/265

/*
1. 아이디어
기본적으로 조합
+ 1) 모음이 1개 이상 있어야 함
+ 2) 자음이 2개 이상 있어야 함
+ 3) 정렬이 되어야 함
 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice123 {
    static char[] charArr; // 사용할 알파벳 배열
    static boolean[] visited; // 방문 체크 배열
    static final char[] aeiou = {'a', 'e', 'i', 'o', 'u'}; // 자음 개수 for문으로 체크할 배열
    static int aeiouCnt; // 자음 개수 변수
    static char[] answerItem; // 정답후보 배열 -> 정답 맞으면 출력
    public static void solution(int L, int C) {
        answerItem = new char[L];
        recur(L, C, 0, 0);
    }

    public static void recur(int L, int C, int start, int depth) {
        if(depth == L) { // 자리수 다 차면 탈출
            // aeiouCnt 구하기
            for (int i = 0; i < answerItem.length; i++) { // 정답후보배열
                for (int j = 0; j < aeiou.length; j++) { // aeiou배열
                    if(answerItem[i] == aeiou[j]) {
                        aeiouCnt++;
                    }
                }
            }
            // 모음개수가 1개 이상이고 자음개수가 2개 이상인 경우만 출력
            if(aeiouCnt >= 1 && L - aeiouCnt >= 2) {
                System.out.println(answerItem);
                aeiouCnt = 0; // 초기화
                return;
            }
            aeiouCnt = 0; // 초기화
            return;
        }

        // 조합 부분(순열은 이 부분 i=0부터 시작
        for (int i = start; i < C; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answerItem[depth] = charArr[i];
                recur(L, C, i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String tmp = "";
        for (int i = 0; i < C; i++) {
            tmp += st.nextToken();
        }
        charArr = tmp.toCharArray();
        Arrays.sort(charArr);

        visited = new boolean[C];

        solution(L, C);
    }
}
