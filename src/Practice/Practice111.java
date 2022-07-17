// 백준 18111 마인크래프트
// https://www.acmicpc.net/problem/18111

/*
1<= 세로 N, 가로 M <= 500
집터의 맨 왼쪽 위 좌표는 0,0
집터 내의 땅의 높이를 일정하게하는 것
땅을 파는건 2초, 땅을 다시 심는건 1초가 걸림
 0 <=최소 시간과 그 경우 땅의 높이 출력 <= 256
 0 <= 인벤에는 땅 B개가 있음 <= 6.4 X 10^7 64,000,000

 1. 아이디어
 2개를 채우는것과 1개를 파는건 동일한 시간
 목표값을 바로 정할 수 있나?
 숫자를 넣을 때 높은건 +, 낮은건 -로 해서 평균값을 구할 수 있을까?
 => 아이디어가 생각이 안날땐 브루트포스!!

배열 집어넣을 때 max값을 받아서 max값부터 시도해보자,
대신 걸리는 시간이 다시 늘어나면 더이상 작업하지 않아도 되니 return

2. 시간복잡도
500*500 = 250,000
O(N^2)이 1만 넘는데 가능하다고? -> 확인 필요

3. 자료구조
n, m, b 모두 int 가능 (-20억 ~ 20억)

 */

package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice111 {
    static int[][] ground; // 땅
    static int maxGround; // 최대높이
    public static void solution(int n, int m, int b) {
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1; // 높이정답 업데이트 변수
        int beforeAnswerT1 = 0; // 이전 정답시간 업데이트 변수 -> 나중에 return에 사용됨
        while(maxGround >= 0) { // 최대높이서부터 내려오면서 계산
            int time = 0; // 시간 초기화
            int block = b; // 블럭개수 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(ground[i][j] > maxGround) { // 평단화 할 높아보다 높은 경우 땅 파야됨
                        time = time + 2 * (ground[i][j] - maxGround);
                        block += ground[i][j] - maxGround;
                    } else if(ground[i][j] < maxGround) { // 평탄화 할 높이보다 낮은 경우 땅 메꿔
                        time = time + (maxGround - ground[i][j]);
                        block -= maxGround - ground[i][j];
                    } else {} // 같으면 넘어가
                }
            }

            if(block >= 0 ) { // 남은 블럭이 0개 이상일 경우만 정답 업데이트
                if(time < answerTime) { // 지금 시간이 이전 시간보다 짧으면 업데이트
                    beforeAnswerT1 = answerTime; // 이전 정답을 보관해놓고
                    answerTime = time; // 새로운 시간 업데이트
                    answerHeight = maxGround; // 새로운 높이 업데이트

                    // 만약 새롭게 정답 업데이트 하려고 했는데 오히려 시간이 증가하는 중이면 V 곡선을 그릴것이기 때문에
                } else if(time > answerTime && answerTime < beforeAnswerT1) {
                    System.out.println(answerTime + " " + answerHeight);
                    return; // 정답 출력하고 끝
                }
            }
            maxGround--;
        }
        System.out.println(answerTime + " " + answerHeight);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ground = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxGround = Math.max(ground[i][j], maxGround);
            }
        }
        solution(n, m, b);
    }
}

/*
다른풀이...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class test9 {
    public static void main(String[] args) throws IOException     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 총 높이가 256개까지니까 배열인덱스 -> 그 높이의 땅의 개수
        int[] cnt = new int[257];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                cnt[num]++;
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;
        for(int i=0; i<=256; i++) // 256개까지의 높이(i) (i로 평탄화 했을때를 구하는 것)
        {
            int time = 0; // 시간 초기화
            int need = B; // 블럭 초기화
            // 배열 돌면서
            for(int j=0; j<=256; j++) // 지금 확인하는 층의 높이(j)
            {
                if(cnt[j] == 0 || i == j) // 그 높이를 가진 땅이 없거나, 지금 확인하는 층의 높이라면
                    continue; // 그냥 넘기기(더하거나 뺄 필요가 없어서)
                // 블럭 차이를 양수로 바꿔주는 곳
                int diff = j - i;
                if(diff < 0)
                    diff = -diff;

                if(j > i)
                {
                    // 블록당 2초의 시간이 들며 인벤토리에 블록이 추가된다.
                    time += 2 * diff * cnt[j];
                    need += diff * cnt[j];
                }
                else
                {
                    // 블록당 1초의 시간이 들며 인벤토리에서 블록이 제거된다.
                    time += diff * cnt[j];
                    need -= diff * cnt[j];
                }
            }

            // 인벤토리에 블록이 모자라면 넘어간다.
            if(need < 0)
                continue;

            if(time < min)
            {
                min = time;
                height = i;
            }
            else if(time == min && i > height)
                height = i;
        }

        System.out.println(min + " " + height);
    }
}
 */