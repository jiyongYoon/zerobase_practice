package Practice;// 백준 2531번 회전초밥
// https://www.acmicpc.net/problem/2531
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice085 {
    public static void solution(int[] bob, int N, int d, int k, int c) {
        int left = 0; // 포인터 1
        int right = 0; // 포인터 2
        int maxCnt = 0; // 최대 종류
        int answer = 0; // 정답
        int[] eat = new int[d]; // 먹은 접시 체크 배열

        // 늦게 가는 포인터가 벨트 마지막에 갈때까지 순회
        while(left < bob.length) {
            if((right - left) == k) { // 연속해서 먹은 접시가 k개면 정답 체크해보기
                if(eat[c-1] == 0) { //그리고 쿠폰번호에 해당하는게 없으면
                    maxCnt++; // 종류 하나 추가 (서비스로 받을수 있음)
                    answer = Math.max(answer, maxCnt); // 정답에 최대 종류 업데이트
                    maxCnt--; //서비스로 받은건 다시 빼기
                } else { // 서비스 못받으면
                    answer = Math.max(answer, maxCnt); // 정답에 최대 종류 업데이트
                }
                if(eat[bob[left]-1] == 1) { // 그 전에 한번만 먹은걸 빼는거면
                    maxCnt--; // 종류 1개 빼기
                }
                eat[bob[left]-1] -= 1; // 늦게 따라가는 인덱스 올리기
                left++;
            }
            // 선행 인덱스 올리기
            if(eat[bob[right%bob.length]-1] == 0) { // 그 전에 먹은 종류가 아니라면
                maxCnt++; // 종류 1개 추가
            }
            eat[bob[right%bob.length]-1] += 1; // 밥번호에 해당하는 접시 먹은거 체크
            right++;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 벨트에 놓인 접시 수
        int d = Integer.parseInt(s[1]); // 초밥 가짓수
        int k = Integer.parseInt(s[2]); // 연속으로 먹는 접시 수
        int c = Integer.parseInt(s[3]); // 쿠폰번호
        int[] bob = new int[N];
        for (int i = 0; i < N; i++) {
            bob[i] = Integer.parseInt(br.readLine());
        }
        solution(bob, N, d, k, c);
    }
}

